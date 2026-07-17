import java.util.Scanner;

public class ArmstrongNumberChecker {

    // Method to check if a number is Armstrong
    public static boolean isArmstrong(int number) {
        if (number < 0) {
            return false; // Armstrong numbers are non-negative
        }

        int originalNumber = number;
        int digits = String.valueOf(number).length();
        int sum = 0;

        while (number > 0) {
            int digit = number % 10;
            sum += Math.pow(digit, digits);
            number /= 10;
        }

        return sum == originalNumber;
    }
}

   
