public class Thermostat {
    private String location;
    private int tempr;
    private static final int min =16;
    private static final int max=30;
    private static int acCount=0;
    Thermostat(String loc, int temp) 
    {
        this.location = loc;
        this.tempr = ((temp<=max && temp>=min) ? temp : 22);
        acCount++;
    }
    Thermostat(String loc)
    {
        this(loc, 22);
    }
    void raise()
    {
        if(tempr<max)
        {
            tempr++;
        }
        else
        {
            System.out.println("Already at maximum (30) \n");
        }
    }
    void lower()
    {
        if(tempr>min)
        {
            tempr--;
        }
        else
        {
            System.out.println("Already at minimum (16) \n");
        }
    }
    int getTemperature() 
        {
            return tempr;
        }
        static int getACCount() 
        {
            return acCount;
        }

    public static void main(String args[])
    {
        Thermostat t1 = new Thermostat("Living Room", 25);
        Thermostat t2 = new Thermostat("Bedroom", 15);
        for(int i=0;i<10;i++)
        {
            t1.raise();
            System.out.println("Temperature t1:"+t1.getTemperature());
        }
        for(int i=0;i<20;i++)
        {
            t1.lower();
            System.out.println("Temperature t1:"+t1.getTemperature());
        }
        System.out.println("Total Active thermostats: "+Thermostat.getACCount());
    }
}
