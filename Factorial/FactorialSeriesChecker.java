//package Factorial;

public class FactorialSeriesChecker {

    public double calculateSeries(int n) {
        double sum = 0.0;

        for (int i = 1; i <= n; i++) {
            long factorial = 1;

            for (int j = 1; j <= i; j++) {
                factorial *= j;
            }

            sum += 1.0 / factorial;
        }

        return sum;
    }
}