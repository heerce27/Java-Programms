import java.util.Scanner;
public class VendinM {

    enum Coin{
    ONE,TWO,FIVE,TEN
}
public static void main(String[] args)
{
    final int PRICE=15;
    int total=0;
    Scanner sc= new Scanner(System.in);
    System.out.print("Snack price :"+PRICE);
    System.out.print("\nInsert coins(ONR,TWO,FIVE,TEN):");
    while(total<PRICE)
    {
        System.out.print("Coin:");
        String input = sc.next().toUpperCase();
        Coin c;
    try {
        c = Coin.valueOf(input);
    } catch (IllegalArgumentException e) {
        System.out.println("Invalid coin!");
        continue;
    }
        switch (c) {
            case ONE:
                total+=1;
                break;
            case TWO:
                total+=2;
                break;
            case FIVE:
                total+=5;
                break;
            case TEN:
                total+=10;
                break;
            default:
                System.out.print("Nothing");
                break;
        } System.out.println("Total inserted = " + total);
        
        }
        System.out.println("Snack dispensed!");
        if (total > PRICE) {
        System.out.println("Change = " + (total - PRICE));
    }
    sc.close();
}
}

