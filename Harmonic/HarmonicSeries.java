public class HarmonicSeries {

    // Method to generate and print harmonic series
    public static void generateHarmonicSeries(int n) {
        double sum = 0.0;

        System.out.print("Harmonic Series: ");
        for (int i = 1; i <= n; i++) {
            sum += 1.0 / i; // Add term to sum
            System.out.print("1/" + i);
            if (i < n) {
                System.out.print(" + ");
            }
        }

        System.out.printf("%nSum of series up to %d terms: %.6f%n", n, sum);
    }

}
