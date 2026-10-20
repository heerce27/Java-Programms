interface Switchable {
    void on();
    void off();
    default void toggle() {
        System.out.println("Toggling device...");
    }
}

class Fan implements Switchable {
    public void on() {
        System.out.println("Fan is ON");
    }
    public void off() {
        System.out.println("Fan is OFF");
    }
}

class Light implements Switchable {
    public void on() {
        System.out.println("Light is ON");
    }
    public void off() {
        System.out.println("Light is OFF");
    }
}

@FunctionalInterface
interface SwitchPermission {
    boolean maySwitchOn(Switchable device, int hour);
}

public class Main {
    public static void main(String[] args) {

        Switchable[] devices = {
            new Fan(),
            new Light()
        };

        for (Switchable device : devices) {
            device.on();
            device.toggle();
            device.off();
            System.out.println();
        }

        SwitchPermission permission1 = new SwitchPermission() {
            public boolean maySwitchOn(Switchable device, int hour) {
                return hour >= 6 && hour <= 22;
            }
        };

        SwitchPermission permission2 = (device, hour) -> hour >= 6 && hour <= 22;
        System.out.println("Anonymous Class:");
        System.out.println("At 10 AM: " + permission1.maySwitchOn(new Fan(), 10));
        System.out.println("Lambda:");
        System.out.println("At 11 PM: " + permission2.maySwitchOn(new Light(), 23));
    }
}