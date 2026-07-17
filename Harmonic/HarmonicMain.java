import java.util.Scanner;
public class HarmonicMain {
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter the number of terms (n): ");
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a positive integer.");
                return;
            }

            int n = sc.nextInt();

            if (n <= 0) {
                System.out.println("Number of terms must be greater than zero.");
                return;
            }
            HarmonicSeries.generateHarmonicSeries(n);

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}