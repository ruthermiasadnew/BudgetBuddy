import java.util.ArrayList;

public class BudgetBuddyTest {
    public static void main(String[] args) {

        // Create a BudgetTracker instance
        BudgetTracker tracker = new BudgetTracker();

        // Add Income entries
        tracker.addEntry(new Income("Paycheck", 1500.00, "2025-09-01"));
        tracker.addEntry(new Income("Scholarship", 500.00, "2025-09-03"));

        // Add Expense entries
        tracker.addEntry(new Expense("Rent + WiFi", 500.00, "2025-09-05"));
        tracker.addEntry(new Expense("Food", 100.00, "2025-09-07"));
        tracker.addEntry(new Expense("Self Care", 150.00, "2025-09-08"));
        tracker.addEntry(new Expense("Tuition", 1000.00, "2025-09-09"));

        // Get entries from tracker
        ArrayList<FinancialEntry> entries = tracker.getEntries();

        // Summary Output
        System.out.println("========================================");
        System.out.println("         📋 Budget Summary Report       ");
        System.out.println("========================================");

        System.out.printf("Total Income:    $%.2f%n", BudgetSummary.getTotalIncome(entries));
        System.out.printf("Total Expenses:  $%.2f%n", BudgetSummary.getTotalExpense(entries));
        System.out.printf("Net Balance:     $%.2f%n", BudgetSummary.getNetBalance(entries));
        System.out.printf("Financial Zone:  %s%n", BudgetSummary.getZone(entries));

        System.out.println("\n========================================");
        System.out.println("           🧾 Full Entry List           ");
        System.out.println("========================================");

        for (FinancialEntry entry : entries) {
            System.out.println(entry);
        }
    }
}