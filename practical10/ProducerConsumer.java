import java.util.*;

public class ProducerConsumer {
    static Queue<Integer> buffer = new LinkedList<>();
    static final int SIZE = 3;

    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    synchronized (buffer) {
                        while (buffer.size() == SIZE)
                            buffer.wait();

                        buffer.add(i);
                        System.out.println("Produced: " + i);
                        buffer.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    synchronized (buffer) {
                        while (buffer.isEmpty())
                            buffer.wait();

                        System.out.println("Consumed: " + buffer.remove());
                        buffer.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}