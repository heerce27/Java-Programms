import java.util.Scanner;
public class MiniBank {
    private double balance;
    enum MenuOption
    {
        OPEN_ACCOUNT, DEPOSIT, WITHDRAW, TRANSFER ,EXIT  
    }
    public record BankInfo(String name, String branch) {
}

static class Customer
{
    private String name,email,mobile;
    private final String customerId= generateCustomerId();
    private static long customerCounter =100;
    private static String generateCustomerId(){
        customerCounter++;
        return "CUST" + String.format("%05d", customerCounter);
    }
    Customer(String name,String email,String mobile)
    {
        this.name=name;
        this.email=email;
        this.mobile=mobile;
    }
    String getCustomerId()
    {
        return customerId;
    }
    String getName()
    {
        return name;
    }
    String getEmail()
    {
        return email;
    }
    String getMobile()
    {
        return mobile;
    }
    
}

static class Account
{
    private final String accountNumber = generateAccountNumber();
    private String ownerName;
    private long balance ;
    private boolean active;
    private static long accountCounter = 1000;
    private static String generateAccountNumber(){
        accountCounter++;
        return "AC" + String.format("%06d", accountCounter);
    }
    Account(String ownerName,long balance)
    {
        this.ownerName=ownerName;
        this.balance=balance;
        this.active=true;
    }
    Account(String ownerName)
    {
        this(ownerName,0);
    }
    void deposit(long amt)
    {
    if(amt>0)
    {
        balance+=amt;
        System.out.println("Deposited:"+amt);
    }
    else
        System.out.println("Invalid amount. Deposit failed.");
    }
    boolean withdraw(long amt)
    {
    if(amt>0 && amt<=balance)
    {
        balance-=amt;
        System.out.println("Withdrawn:"+amt);
        return true;
    }
    else
    { 
        System.out.println("Invalid amount or insufficient balance. Withdrawal failed.");
        return false;
    }
    }

    String getAccountNumber()
    {
        return accountNumber;
    }
    String getOwnerName()
    {
        return ownerName;
    }
    long getBalance()
    {
        return balance;
    }

}


public static void main(String args[]){
    System.out.println("Welcome to MiniBank");
    Scanner scanner = new Scanner(System.in);
    BankInfo bankInfo = new BankInfo("MiniBank", "Main Branch");
    System.out.println("Bank Name: " + bankInfo.name() + ", Branch: " + bankInfo.branch());
    // int ch;
    // do{
    //     System.out.println("1. Open Account");
    //     System.out.println("2. Deposit");
    //     System.out.println("3. Withdraw");
    //     System.out.println("4. Transfer");
    //     System.out.println("5. Exit");
    //     System.out.print("Enter your choice: ");
    //     ch = scanner.nextInt();
    //    String message = switch(ch){
    //         case 1 -> {
    //             System.out.print("Enter your name: ");
    //             String name = scanner.next();
    //             System.out.print("Enter your email: ");
    //             String email = scanner.next();  
    //             System.out.print("Enter your mobile number: ");
    //             String mobile = scanner.next();
    //             };
    //             case 2 -> "Deposit - ";
    //             case 3 -> "Withdraw - ";
    //             case 4 -> "Transfer - ";
    //             case 5 -> "Exiting MiniBank...";
    //             default -> "Invalid choice. Please try again.";
    //    };
    //     System.out.println(message);
    // }while(ch != 5);
  Account[] accounts = new Account[3];

        // Create three accounts
        accounts[0] = new Account("Heer", 1000);
        accounts[1] = new Account("Rahul");
        accounts[2] = new Account("Priya", 500);

        // Perform deposits
        accounts[0].deposit(500);
        accounts[1].deposit(2000);
        accounts[2].deposit(300);

        // Perform withdrawals
        accounts[0].withdraw(200);
        accounts[1].withdraw(500);
        accounts[2].withdraw(100);

        // Print balances
        for (Account account : accounts) {

            System.out.println(
                account.getAccountNumber() +
                " | Owner: " + account.getOwnerName() +
                " | Balance: " + account.getBalance()
            );
}
}
}