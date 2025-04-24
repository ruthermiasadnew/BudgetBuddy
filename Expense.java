/**
 * Represents an expense entry in the budget (e.g., rent, wifi, food).
 * Inherits common financial attributes from FinancialEntry.
 * 
 * @author Ruth Adnew
 * @version 23 April 2025
 */
public class Expense extends FinancialEntry {

    // Full constructor
    public Expense(String description, double amount, String date) {
        super(amount, description, date, "Expense");
    }


    // No-arg constructor
    public Expense() {
        super();
    }

    // Override getType to return "Expense"
    @Override
    public String getType() {
        return "Expense";
    }
}