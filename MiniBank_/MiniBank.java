import java.util.Objects;
import java.util.Scanner;

//Mini bank class 
public class MiniBank {
    private double balance;
    enum MenuOption
    {
        OPEN_ACCOUNT, DEPOSIT, WITHDRAW, TRANSFER ,EXIT  
    }
    public record BankInfo(String name, String branch) {
}


//Customer class
static class Customer implements Cloneable
{
    private String name,email,mobile;
    private final String customerId= generateCustomerId();
    private static long customerCounter =100;
    private Address address;
    private static String generateCustomerId(){
        customerCounter++;
        return "CUST" + String.format("%05d", customerCounter);
    }
    Customer(String name,String email,String mobile,Address address)
    {
        this.name=name;
        this.email=email;
        this.mobile=mobile;
        this.address=address;
    }
    
    public Address getAddress() {
    return address;
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
    @Override
    public Customer clone() {
    try {
        return (Customer) super.clone();
    } catch (CloneNotSupportedException e) {
        throw new AssertionError();
    }
    } 

    //Address class
    public static class Address {
    private String line;
    private String city;
    private String pincode;

    public Address(String line, String city, String pincode) {
        this.line = line;
        this.city = city;
        this.pincode = pincode;
    }

    public String getLine() {
        return line;
    }

    public String getCity() {
        return city;
    }

    public String getPincode() {
        return pincode;
    }
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

    public String toString(){
         return "\nAccount Number: " + accountNumber  + " \nOwner Name:  "  + ownerName + "\nBalance: "+balance;
    }
    public boolean equals(Object o){
        if(this==o){
            return true;
        }
        if(!(o instanceof Account)){
            return false;
        }
        Account c= (Account)o;
       return this.accountNumber.equals(c.accountNumber);
    }
    public int hashCode(){
        return Objects.hash(accountNumber);
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
        System.out.println("\nAccount Details:");
for (Account account : accounts) {
    System.out.println(account.toString());
}
System.out.println("\nEquals Test:");
Account a1 = new Account("Test", 1000);
Account a2 = new Account("Test", 1000);

System.out.println("a1 equals a2: " + a1.equals(a2));

System.out.println("\ninstanceof Test:");
Object obj = accounts[0];

if (obj instanceof Account) {
    System.out.println("obj is an Account");
}
scanner.close();
}
}
