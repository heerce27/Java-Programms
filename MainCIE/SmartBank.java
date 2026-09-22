abstract class Account {
    private String name;
    private String acno;
    private double bal=0.0;;
    
    public Account(String hname,String accno,double ball){
        name=hname;
        acno=accno;
        bal=ball;
    }
   
    void deposit(double amt){
        if(amt>=0){
            System.out.println("Amount deposited!\n");
            bal+=amt;
        }
        else
            System.out.println("Error occured");

    }
    public abstract boolean withdraw(double amt);
    String getAcno(){
        return acno;
    }
    String getholdername(){
        return name;
    }
     double getbal(){
        return bal;
    }
    protected void setBalance(double balance) {
        bal = balance;
    }

    public abstract double getInterestRate();

    @Override
    public String toString()
    {
         return "Account Number: " + acno +
               ", Holder: " + name +
               ", Balance: " + bal +
               ", Interest Rate: " + getInterestRate() + "%";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Account))
            return false;
        Account other = (Account) obj;
        return acno.equals(other.acno);
    }

    @Override
    public int hashCode() {
        return acno.hashCode();
    }

}

class SavingsAcc  extends Account{
    // boolean withdraw (double amt){

    // }
    private static final double minbal = 1000;
    private static final double intrate = 4;
    SavingsAcc(String hname,String accno,double ball){
        super(hname, accno, ball);
    }
    @Override
    public boolean withdraw(double amt){
        if (amt <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return false;
        }
        if (getbal()-amt >= minbal) {
            setBalance(getbal()-amt);
            System.out.println("Withdraw successfull");
            return true;
        }
        System.out.println("Savings withdrawal unsuccessfull \n Minimum balance of "+minbal+" must be maintained.\n");
        return false;
    }
   @Override
    public double getInterestRate() {
        return intrate;
    }

    public double getMinimumBalance() {
        return minbal;
    }
}

/**
 * CurrentClass extends 
 */
class CurrentAccount extends Account  {
    private static double overdflimit=5000;
    private static double intrate=0;
    
    public CurrentAccount(String hname, String accno,double ball ){
        super(hname,accno,ball);
    }
    @Override
    public boolean withdraw(double amt){
        if (amt <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return false;
        }
        if (getbal()-amt >= overdflimit) {
            setBalance(getbal()-amt);
            System.out.println("Withdraw successfull");
            return true;
        }
        System.out.println("Current withdrawal unsuccessfull \n Overdraft limit of  "+overdflimit+" exceeded.\n");
        return false;
    }

    @Override
    public double getInterestRate(){
        return intrate;
    }
    public double getOverdfLimit(){
        return overdflimit;
    }

}

class FixedDepo extends Account
{
    private static final double intrate=7;
    FixedDepo(String hname,String accno, double ball){
        super(hname, accno, ball);
    }

    @Override
    public boolean withdraw(double amt){
        System.out.println("Withdraw unsuccesfull! \n Fixed Deposite account does not allow !\n");
        return false;
    }

    @Override 
    public double getInterestRate(){
        return intrate;
    }

}

class SalaryAcc extends Account
{   
    private int intrate=9;
    SalaryAcc(String hname, String accno, double ball){
        super(hname, accno, ball);
    }

    @Override
    public boolean withdraw(double amt){
        if(amt>0 && (getbal()-amt)<5000){
            System.out.println("Withdrawal successfull\n");
            setBalance(getbal() - amt);
            return true;
        }
        else
        {
            System.out.println("Salary Account Withdrawal unsuccessfull!\n");
            return false;
        }
    }
    @Override 
    public double getInterestRate(){
        return intrate;
    } 
}

public class SmartBank
{
    public static void main(String[] args){
        Account[] accounts = new Account[4];

        accounts[0] = new SavingsAcc("Heer", "108", 5000);
        accounts[1] = new CurrentAccount("Diya", "114", 2000);
        accounts[2] = new FixedDepo("Deep", "120", 10000);
        accounts[3] = new SalaryAcc("Jeet", "121", 8000);

        System.out.println("--- All Accounts ---");
        for(Account acc : accounts){
            System.out.println(acc);
        }

        System.out.println("\nDeposit:\n");
        accounts[0].deposit(1000);
        accounts[1].deposit(2000);

        System.out.println("\nWithdraw: \n");
        accounts[0].withdraw(2000);

        System.out.println("\n Unsuccessfull Withdrawal :\n");
        accounts[0].withdraw(4000);

        System.out.println("\nFd withdrawal: \n");
        accounts[2].withdraw(1000);

        System.out.println("\nInterest rates:\n");
         for (Account acc : accounts) {
            System.out.println(acc.getAcno() +" -> " +acc.getInterestRate() +"%");
        }

        System.out.println("\nAccount specific priority:");
        for (Account acc : accounts) {
            if (acc instanceof SavingsAcc) {
                SavingsAcc savings =(SavingsAcc) acc;

                System.out.println( "Savings Account " +acc.getAcno() +
                    " minimum balance = ₹" +
                    savings.getMinimumBalance()
                );
            }

            if (acc instanceof CurrentAccount) {
                CurrentAccount current = (CurrentAccount) acc;
                System.out.println(
                    "Current Account " + acc.getAcno() 
                    );
            }
        }
        System.out.println("\nEqualityTest:\n");
        Account a1= new SavingsAcc("Meet", "125", 1200);
        Account a2=new CurrentAccount("Meet", "125", 1200);
        System.out.println("a1 equals a2? " + a1.equals(a2));
    }
}