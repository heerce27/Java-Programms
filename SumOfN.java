import java.util.Scanner;
public class SumOfN {
    public static void main(String args[])
    {
        int n,sum=0;
        System.out.println("Enter the value of n:");
        Scanner sc= new Scanner(System.in);
        n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            sum+=i;
        }
        System.out.println("Sum of first "+n+" natural numbers is: "+sum);
        sc.close();
    }
}
