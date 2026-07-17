import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the value of n: ");

        if (!sc.hasNextInt()) {
            System.out.println("Invalid input! Please enter an integer.");
            return;
        }

        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a positive integer.");
            return;
        }

        FactorialSeriesChecker checker = new FactorialSeriesChecker();

        double result = checker.calculateSeries(n);

        System.out.println("Sum of the series = " + result);

        sc.close();
    }
}