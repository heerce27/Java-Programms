
class Counter {
    int count = 0;
    public void increment() {
        count++;
    }
    public synchronized void synchronizedIncrement() {
        count++;
    }
}

public class CounterRace {
    static final int THREADS = 5;
    static final int INCREMENTS = 100000;
    public static void main(String[] args)
            throws InterruptedException {
        Counter counter = new Counter();
        Thread[] threads = new Thread[THREADS];

        // Test 1: Without synchronization
        for (int i = 0; i < THREADS; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < INCREMENTS; j++) {
                    counter.increment();
                }
            });
            threads[i].start();
        }
        for (Thread t : threads) {
            t.join();
        }
        System.out.println("Without synchronization:");
        System.out.println("Expected: " + (THREADS * INCREMENTS));
        System.out.println("Actual: " + counter.count);

        // Test 2: With synchronization
        counter.count = 0;
        for (int i = 0; i < THREADS; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < INCREMENTS; j++) {
                    counter.synchronizedIncrement();
                }
            });
            threads[i].start();
        }
        for (Thread t : threads) {
            t.join();
        }
        System.out.println("\nWith synchronization:");
        System.out.println("Expected: " + (THREADS * INCREMENTS));
        System.out.println("Actual: " + counter.count);
    }
}