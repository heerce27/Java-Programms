import java.util.Scanner;

public class ReverseNum {
    public static void main(String args[])
    {
        int num,rev=0;
        System.out.println("Enter a number:");
        Scanner sc= new Scanner(System.in);
        num=sc.nextInt();
        while(num!=0)
        {
            //num=num%10;
            rev=rev*10+num%10;
            num=num/10;
        }
        System.out.println("Reversed number: " + rev);
        sc.close();
    }
}
