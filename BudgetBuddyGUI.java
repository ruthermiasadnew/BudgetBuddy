import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BudgetBuddyGUI extends JFrame {

    private JTextField descriptionField, amountField, dateField;
    private JComboBox<String> typeDropdown;
    private JTextArea summaryArea;
    private JButton addButton, clearButton;

    public BudgetBuddyGUI() {
        setTitle("💸 BudgetBuddy");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel for input fields
        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Enter Transaction Details"));

        descriptionField = new JTextField();
        amountField = new JTextField();
        dateField = new JTextField();
        typeDropdown = new JComboBox<>(new String[]{"Income", "Expense"});

        inputPanel.add(new JLabel("Description:"));
        inputPanel.add(descriptionField);
        inputPanel.add(new JLabel("Amount ($):"));
        inputPanel.add(amountField);
        inputPanel.add(new JLabel("Date (YYYY-MM-DD):"));
        inputPanel.add(dateField);
        inputPanel.add(new JLabel("Type:"));
        inputPanel.add(typeDropdown);

        addButton = new JButton("Add Entry");
        clearButton = new JButton("Clear");

        inputPanel.add(addButton);
        inputPanel.add(clearButton);

        // Summary panel
        summaryArea = new JTextArea(5, 40);
        summaryArea.setEditable(false);
        summaryArea.setBorder(BorderFactory.createTitledBorder("Summary"));

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(summaryArea), BorderLayout.CENTER);

        // Event listeners
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String desc = descriptionField.getText();
                String amtText = amountField.getText();
                String date = dateField.getText();
                String type = (String) typeDropdown.getSelectedItem();

                try {
                    double amount = Double.parseDouble(amtText);
                    summaryArea.append(type + ": " + desc + ", $" + amount + ", on " + date + "\n");
                    clearFields();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(BudgetBuddyGUI.this, "Please enter a valid amount.");
                }
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
    }

    private void clearFields() {
        descriptionField.setText("");
        amountField.setText("");
        dateField.setText("");
        typeDropdown.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BudgetBuddyGUI().setVisible(true));
    }
}