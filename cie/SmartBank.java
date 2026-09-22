abstract class Account {
    private String accountNumber;
    private String holderName;
    private double balance;

    public Account(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    // Protected setter so subclasses can modify balance
    // only through controlled operations.
    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful: ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Each account type follows different withdrawal rules
    public abstract boolean withdraw(double amount);

    // Each account provides its own interest rate
    public abstract double getInterestRate();

    @Override
    public String toString() {
        return "Account Number: " + accountNumber +
               ", Holder: " + holderName +
               ", Balance: ₹" + balance +
               ", Interest Rate: " + getInterestRate() + "%";
    }

    // Same account number => same account
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Account))
            return false;

        Account other = (Account) obj;

        return accountNumber.equals(other.accountNumber);
    }

    @Override
    public int hashCode() {
        return accountNumber.hashCode();
    }
}


// ----------------------------------------------------
// SAVINGS ACCOUNT
// ----------------------------------------------------

class SavingsAccount extends Account {
    private static final double MINIMUM_BALANCE = 1000;
    private static final double INTEREST_RATE = 4;

    public SavingsAccount(String accountNumber,
                          String holderName,
                          double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public boolean withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return false;
        }

        if (getBalance() - amount >= MINIMUM_BALANCE) {
            setBalance(getBalance() - amount);

            System.out.println(
                "Savings withdrawal successful: ₹" + amount
            );

            return true;
        }

        System.out.println(
            "Savings withdrawal unsuccessful: " +
            "minimum balance of ₹" + MINIMUM_BALANCE +
            " must be maintained."
        );

        return false;
    }

    @Override
    public double getInterestRate() {
        return INTEREST_RATE;
    }

    public double getMinimumBalance() {
        return MINIMUM_BALANCE;
    }
}


// ----------------------------------------------------
// CURRENT ACCOUNT
// ----------------------------------------------------

class CurrentAccount extends Account {
    private static final double OVERDRAFT_LIMIT = 5000;
    private static final double INTEREST_RATE = 0;

    public CurrentAccount(String accountNumber,
                          String holderName,
                          double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public boolean withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return false;
        }

        if (getBalance() - amount >= -OVERDRAFT_LIMIT) {
            setBalance(getBalance() - amount);

            System.out.println(
                "Current withdrawal successful: ₹" + amount
            );

            return true;
        }

        System.out.println(
            "Current withdrawal unsuccessful: " +
            "overdraft limit of ₹" + OVERDRAFT_LIMIT +
            " exceeded."
        );

        return false;
    }

    @Override
    public double getInterestRate() {
        return INTEREST_RATE;
    }

    public double getOverdraftLimit() {
        return OVERDRAFT_LIMIT;
    }
}


// ----------------------------------------------------
// FIXED DEPOSIT ACCOUNT
// ----------------------------------------------------

class FixedDepositAccount extends Account {
    private static final double INTEREST_RATE = 7;

    public FixedDepositAccount(String accountNumber,
                               String holderName,
                               double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public boolean withdraw(double amount) {
        System.out.println(
            "Withdrawal unsuccessful: " +
            "Fixed Deposit account does not allow withdrawal."
        );

        return false;
    }

    @Override
    public double getInterestRate() {
        return INTEREST_RATE;
    }
}


// ----------------------------------------------------
// NEW ACCOUNT TYPE
// Example: Salary Account
// ----------------------------------------------------

class SalaryAccount extends Account {
    private static final double INTEREST_RATE = 3;

    public SalaryAccount(String accountNumber,
                         String holderName,
                         double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public boolean withdraw(double amount) {

        if (amount > 0 && amount <= getBalance()) {
            setBalance(getBalance() - amount);

            System.out.println(
                "Salary Account withdrawal successful: ₹" + amount
            );

            return true;
        }

        System.out.println(
            "Salary Account withdrawal unsuccessful."
        );

        return false;
    }

    @Override
    public double getInterestRate() {
        return INTEREST_RATE;
    }
}


// ----------------------------------------------------
// MAIN CLASS
// ----------------------------------------------------

public class SmartBank {
    public static void main(String[] args) {

        // Common Account reference storing different objects
        Account[] accounts = new Account[4];

        accounts[0] = new SavingsAccount(
            "S101", "Heer", 5000
        );

        accounts[1] = new CurrentAccount(
            "C101", "Rahul", 2000
        );

        accounts[2] = new FixedDepositAccount(
            "F101", "Priya", 10000
        );

        accounts[3] = new SalaryAccount(
            "SAL101", "Amit", 8000
        );


        // -----------------------------------------
        // Display all accounts
        // -----------------------------------------

        System.out.println("========== ALL ACCOUNTS ==========");

        for (Account acc : accounts) {
            System.out.println(acc);
        }


        // -----------------------------------------
        // Deposits
        // -----------------------------------------

        System.out.println("\n========== DEPOSITS ==========");

        accounts[0].deposit(1000);
        accounts[1].deposit(2000);


        // -----------------------------------------
        // Successful withdrawal
        // -----------------------------------------

        System.out.println("\n========== SUCCESSFUL WITHDRAWAL ==========");

        accounts[0].withdraw(2000);


        // -----------------------------------------
        // Unsuccessful withdrawal
        // Savings account must maintain ₹1000
        // -----------------------------------------

        System.out.println("\n========== UNSUCCESSFUL WITHDRAWAL ==========");

        accounts[0].withdraw(4000);


        // -----------------------------------------
        // Fixed Deposit withdrawal
        // -----------------------------------------

        System.out.println("\n========== FD WITHDRAWAL ==========");

        accounts[2].withdraw(1000);


        // -----------------------------------------
        // Display interest rates
        // -----------------------------------------

        System.out.println("\n========== INTEREST RATES ==========");

        for (Account acc : accounts) {
            System.out.println(
                acc.getAccountNumber() +
                " -> " +
                acc.getInterestRate() +
                "%"
            );
        }


        // -----------------------------------------
        // instanceof
        // -----------------------------------------

        System.out.println("\n========== ACCOUNT-SPECIFIC PROPERTY ==========");

        for (Account acc : accounts) {

            if (acc instanceof SavingsAccount) {

                SavingsAccount savings =
                    (SavingsAccount) acc;

                System.out.println(
                    "Savings Account " +
                    acc.getAccountNumber() +
                    " minimum balance = ₹" +
                    savings.getMinimumBalance()
                );
            }

            if (acc instanceof CurrentAccount) {

                CurrentAccount current =
                    (CurrentAccount) acc;

                System.out.println(
                    "Current Account " +
                    acc.getAccountNumber() +
                    " overdraft limit = ₹" +
                    current.getOverdraftLimit()
                );
            }
        }


        // -----------------------------------------
        // equals()
        // -----------------------------------------

        System.out.println("\n========== EQUALITY TEST ==========");

        Account a1 =
            new SavingsAccount("S101", "Another Person", 500);

        Account a2 =
            new CurrentAccount("S101", "Someone Else", 2000);

        System.out.println(
            "a1 equals a2? " + a1.equals(a2)
        );
    }
}