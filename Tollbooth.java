import java.util.Scanner;
public class Tollbooth {
    public static void main(String args[])
    {
        double total=0;
        int c=0,b=0,t=0;
        int v=0;
        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("Enter vehicle type:(1-Car,2-Bike,3-Truck,4-Exit)");
            
            v=sc.nextInt();
            switch(v)
            {
                case 1:
                    total+=50.00;
                    c++;
                    break;
                case 2:
                    total+=20.00;
                    b++;
                    break;
                case 3:
                    total+=150.00;
                    t++;
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid vehicle type!");
            }
        
        }while(v!=4);
        System.out.println("Total vehicles: Cars=" + c + ", Bikes=" + b + ", Trucks=" + t);
        System.out.println("Total amount collected: " + total+" Rs");
        sc.close();
    } 
    
}
