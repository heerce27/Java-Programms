import java.util.Scanner;
public class Interest{
    public static void main(String args[])
    {
        int p,r,t;
        float si;   
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter principal, rate and time:");
        p = sc.nextInt();
        r = sc.nextInt();
        t = sc.nextInt();
        si = (p * r * t) / 100;
        System.out.println("Simple Interest: " + si);
        sc.close();
    }
}