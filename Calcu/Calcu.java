import java.util.Scanner;
public class Calc {
    public static void main(String args[])
    {
        int op=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a:");
        int a=sc.nextInt();
        System.out.println("Enter b:");
        int b=sc.nextInt();
        System.out.println("Enter function:");
        char ch=sc.next();
        
        switch (ch) {
            case 1:
                Add h=new Add();
                op=h.addT(a, b);
                break;
            case 2:
                Minus m=new Minus();
                op=m.minus(a, b);
                break;
            case 3:
                Divide d=new Divide();
                op=d.divide(a, b) ;
                break;
            case 4:
                op=a*b;
                break;
            default:
                System.out.print("Not apropriate");
                break;
        }
        System.out.print(op);
    }
}