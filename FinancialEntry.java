/**
 * Abstract superclass representing a financial entry (either income or expense).
 * Tracks the amount, category, pay period, and purpose of the entry.
 * Subclasses will implement getType() to specify if it’s Income or Expense.
 *
 * Author: Ruth Adnew
 * Date: 23 April 2025
 */
public abstract class FinancialEntry {
    private double amount;
    private String category;    // e.g. "Rent", "Food", "Savings"
    private String date;        // pay date or transaction date
    private String notes;       // purpose or notes like "350 red", "Tuition", etc.

    // Full constructor
    public FinancialEntry(double amount, String category, String date, String notes) {
        this.amount = amount > 0 ? amount : 0;
        this.category = (category != null) ? category : "Uncategorized";
        this.date = (date != null) ? date : "N/A";
        this.notes = (notes != null) ? notes : "";
    }

    // No-arg constructor with default values
    public FinancialEntry() {
        this(0.0, "Uncategorized", "N/A", "");
    }

    // Getters and setters
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        if (amount > 0) {
            this.amount = amount;
        }
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        if (category != null && !category.isEmpty()) {
            this.category = category;
        }
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        if (date != null && !date.isEmpty()) {
            this.date = date;
        }
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = (notes != null) ? notes : "";
    }

    // Abstract method for subclass to specify type
    public abstract String getType();  // Will return "Income" or "Expense"

    // Zone logic: Red (below 15%), Yellow (15–30%), Green (above 30%)
    public String getSpendingZone(double totalIncome) {
        if (totalIncome <= 0) return "Unknown";
        double ratio = amount / totalIncome;
        if (ratio < 0.15) return "🟥 Red Zone";
        else if (ratio < 0.30) return "🟨 Yellow Zone";
        else return "🟩 Green Zone";
    }

    @Override
    public String toString() {
        return String.format("Type: %s%nAmount: $%.2f%nCategory: %s%nDate: %s%nNotes: %s%n",
                getType(), amount, category, date, notes);
    }
}