// BudgetTracker.java
import java.util.ArrayList;

public class BudgetTracker {
    private ArrayList<FinancialEntry> entries;

    public BudgetTracker() {
        entries = new ArrayList<>();
    }

    public void addEntry(FinancialEntry entry) {
        if (entry != null) {
            entries.add(entry);
        }
    }

    public ArrayList<FinancialEntry> getEntries() {
        return entries;
    }

    public void printAllEntries() {
        for (FinancialEntry e : entries) {
            System.out.println(e);
        }
    }
}

