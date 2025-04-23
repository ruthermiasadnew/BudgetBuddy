// ✅ UML DESIGN FOR BUDGETBUDDY APP
// With superclass/subclasses, and all that clean OOP goodness

// SUPERCLASS
public abstract class Transaction {
    protected double amount;
    protected String description;
    protected String category;
    protected LocalDate date;

    public Transaction(double amount, String description, String category, LocalDate date) {
        this.amount = amount;
        this.description = description;
        this.category = category;
        this.date = date;
    }

    public abstract String getType();
    public double getAmount() { return amount; }
    public String getDescription() { return description; }
    public String getCategory() { return category; }
    public LocalDate getDate() { return date; }
}

// SUBCLASS 1
public class Expense extends Transaction {
    public Expense(double amount, String description, String category, LocalDate date) {
        super(amount, description, category, date);
    }
    @Override
    public String getType() { return "Expense"; }
}

// SUBCLASS 2
public class Income extends Transaction {
    public Income(double amount, String description, String category, LocalDate date) {
        super(amount, description, category, date);
    }
    @Override
    public String getType() { return "Income"; }
}

// PLANNER CLASS
public class BudgetPlanner {
    private double expectedIncome;
    private double targetSavings;
    private List<Expense> recurringExpenses;

    public BudgetPlanner(double expectedIncome, double targetSavings) {
        this.expectedIncome = expectedIncome;
        this.targetSavings = targetSavings;
        this.recurringExpenses = new ArrayList<>();
    }

    public void addRecurringExpense(Expense expense) {
        recurringExpenses.add(expense);
    }

    public String generatePlan() {
        double totalExpenses = recurringExpenses.stream().mapToDouble(Expense::getAmount).sum();
        double leftover = expectedIncome - totalExpenses - targetSavings;

        if (leftover < 0) return "Red Zone: Adjust your budget!";
        if (leftover < 100) return "Yellow Zone: Tight budget, spend wisely.";
        return "Green Zone: You're on track!";
    }
}

// TRACKER CLASS
public class BudgetTracker {
    private List<Transaction> transactions;

    public BudgetTracker() {
        transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction t) {
        transactions.add(t);
    }

    public double getBalance() {
        return transactions.stream()
            .mapToDouble(t -> t instanceof Income ? t.getAmount() : -t.getAmount())
            .sum();
    }

    public String getStatus() {
        double balance = getBalance();
        if (balance < 100) return "🔴 Red Zone";
        if (balance < 500) return "🟡 Yellow Zone";
        return "🟢 Green Zone";
    }
}

// GUI + MAIN class will use all the above to create the app!
