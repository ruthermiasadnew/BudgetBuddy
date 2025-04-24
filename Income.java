/**
 * Represents an income entry in the budget (e.g., paycheck, scholarship).
 * Inherits common financial attributes from FinancialEntry.
 * 
 * @author Ruth Adnew
 * @version 23 April 2025
 */
public class Income extends FinancialEntry {

    // Full constructor
    public Income(String description, double amount, String date) {
        super(amount, description, date, "Income"); // ✅ now 4 arguments!
    }

    // No-arg constructor
    public Income() {
        super();
    }

    // Override getType to return "Income"
    @Override
    public String getType() {
        return "Income";
    }
}