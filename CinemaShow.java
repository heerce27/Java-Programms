public class CinemaShow {
    private String title;
    private int seatsAvailable; 
    private final int capacity;
    private static int totalBooked=0;
    CinemaShow(String title,int capacity)
    {
        this.title=title;
        this.capacity=capacity;
        this.seatsAvailable=capacity;
    }
    CinemaShow(String title)
    {
        this(title,100);
    }
    boolean book(int n)
    {
        if(n<=seatsAvailable)
        {
            seatsAvailable-=n;
            totalBooked+=n;
            return true;
        }
        else
        {
           return false;
        }
    }

     void cancel(int n) {
        seatsAvailable = Math.min(seatsAvailable + n, capacity);
    }

    int getSeatsAvailable()
    {
        return seatsAvailable;
    }
    static int getTotalBooked()
    {
        return totalBooked;
    }
    public static void main(String[] args) {
        CinemaShow s1 = new CinemaShow("Avengers", 50);
        CinemaShow s2 = new CinemaShow("Inception");

        // Try booking more seats than available
        System.out.println("Booking 55 seats: " + s1.book(55));
        System.out.println("Seats available: " + s1.getSeatsAvailable());

        // Successful booking
        System.out.println("Booking 30 seats: " + s1.book(30));
        System.out.println("Seats available: " + s1.getSeatsAvailable());

        // Cancel 10 seats
        s1.cancel(10);
        System.out.println("After cancelling 10 seats:");
        System.out.println("Seats available: " + s1.getSeatsAvailable());

        // Booking in second cinema
        System.out.println("Booking 70 seats: " + s2.book(70));
        System.out.println("Seats available: " + s2.getSeatsAvailable());

        // Total successful bookings
        System.out.println("Total booked: " + CinemaShow.getTotalBooked());
    }
}
