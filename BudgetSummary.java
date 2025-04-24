// BudgetSummary.java
import java.util.ArrayList;
public class BudgetSummary {
    public static double getTotalIncome(ArrayList<FinancialEntry> entries) {
        return entries.stream()
                .filter(e -> e.getType().equals("Income"))
                .mapToDouble(FinancialEntry::getAmount)
                .sum();
    }

    public static double getTotalExpense(ArrayList<FinancialEntry> entries) {
        return entries.stream()
                .filter(e -> e.getType().equals("Expense"))
                .mapToDouble(FinancialEntry::getAmount)
                .sum();
    }

    public static double getNetBalance(ArrayList<FinancialEntry> entries) {
        return getTotalIncome(entries) - getTotalExpense(entries);
    }

    public static String getZone(ArrayList<FinancialEntry> entries) {
        double balance = getNetBalance(entries);

        if (balance < 0.15 * getTotalIncome(entries)) {
            return "🔴 Red Zone (Caution)";
        } else if (balance < 0.50 * getTotalIncome(entries)) {
            return "🟡 Yellow Zone (Watch Your Spending)";
        } else {
            return "🟢 Green Zone (You're Doing Great)";
        }
    }
    }

