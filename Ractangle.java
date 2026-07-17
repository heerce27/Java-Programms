import java.util.Scanner;
public class Ractangle {
    public class Calculation
    {
        int l,br;
        Calculation(int a,int b)
        {
            l=a;
            br=b;
        }
        float calculateA()
        {
            return l*br;
        }
        float calculateP()
        {
            return 2*(l+br);
        }
    }
    public static void main(String args[])
    {
        int a,b;
        System.out.println("Enter length and breadth:");
        Scanner sc= new Scanner(System.in);
        Ractangle h= new Ractangle();
        a=sc.nextInt();
        b=sc.nextInt();
        Ractangle.Calculation c = h.new Calculation(a, b);
        System.out.println("Area: " + c.calculateA());
        System.out.println("Perimeter: " + c.calculateP());
        sc.close();
    }
}

