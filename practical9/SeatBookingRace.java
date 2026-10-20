class SeatBooking {
    int seatsLeft = 5;
    int successfulBookings = 0;

    public void bookWithoutSync() {
        if (seatsLeft > 0) {
            try {
                Thread.sleep(10); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
            seatsLeft--;
            successfulBookings++;
            System.out.println( Thread.currentThread().getName() + " booked a seat." );
        }
    }

    // With synchronization
    public synchronized void book() {
        if (seatsLeft > 0) {
            seatsLeft--;
            successfulBookings++;
            System.out.println( Thread.currentThread().getName() + " booked a seat." );
        } else {
            System.out.println( Thread.currentThread().getName() + " failed: No seats left." );
        }
    }
}

public class SeatBookingRace {
    public static void main(String[] args)
            throws InterruptedException {

        // Test 1: Without synchronization
        SeatBooking b1 = new SeatBooking();
        Thread[] t1 = new Thread[10];
        System.out.println("Without Synchronization:");
        for (int i = 0; i < 10; i++) {
            t1[i] = new Thread(b1::bookWithoutSync, "User-" + (i + 1));
            t1[i].start();
        }
        for (Thread t : t1) {
            t.join();
        }
        System.out.println("Successful bookings: " + b1.successfulBookings);
        System.out.println("Seats left: " + b1.seatsLeft);

        // Test 2: With synchronization
        SeatBooking b2 = new SeatBooking();
        Thread[] t2 = new Thread[10];
        System.out.println("\nWith Synchronization:");
        for (int i = 0; i < 10; i++) {
            t2[i] = new Thread(b2::book, "User-" + (i + 1));
            t2[i].start();
        }
        for (Thread t : t2) {
            t.join();
        }
        System.out.println("Successful bookings: " + b2.successfulBookings);
        System.out.println("Seats left: " + b2.seatsLeft);
    }
}