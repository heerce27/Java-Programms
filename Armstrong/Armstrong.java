import java.util.Scanner;
public class Armstrong {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");  
        int num=sc.nextInt();
        int originalNum = num;
        //int digits = String.valueOf(num).length();      
        ArmstrongNumberChecker checker = new ArmstrongNumberChecker();
        if (checker.isArmstrong(num)) {
            System.out.println(originalNum + " is an Armstrong number.");
        } else {
            System.out.println(originalNum + " is not an Armstrong number.");
        }
        sc.close();
    }
}
