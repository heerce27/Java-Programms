import java.util.Scanner;
public class Tollbooth {
    public static void main(String args[])
    {
        double total=0;
        int c=0,b=0,t=0;
        String vehicleType;
        Scanner sc=new Scanner(System.in);
        do{
            System.out.println("Enter vehicle type:(Car,Bike,Truck,done for exit)");
            vehicleType = sc.next();

            switch(vehicleType.toLowerCase())
            {
                case "car"-> {
                    total+=50.00;
                    c++;
                }
                case "bike"-> { 
                    total+=20.00;
                    b++;
                    
                }
                case "truck"-> {
                    total+=150.00;
                    t++;
                    
                }
                case "done"-> {
                    System.out.println("Exiting...");
                }
                default-> {
                    System.out.println("Invalid vehicle type!");
                }
            }
        }while(!vehicleType.equals("done"));
        if (c >= b && c >= t)
            System.out.println("Most frequent: Car");
        else if (b >= c && b >= t)
            System.out.println("Most frequent: Bike");
        else
            System.out.println("Most frequent: Truck");
        System.out.println("Total vehicles: Cars=" + c + ", Bikes=" + b + ", Trucks=" + t);
        System.out.println("Total amount collected: Rs " + total);
        sc.close();
    } 
    
}

                
