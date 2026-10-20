@FunctionalInterface
interface Notifier {
    void send(String message);
}
interface Urgent {
}

class Email implements Urgent {
    String name;
    Email(String name) {
        this.name = name;
    }
}

class SMS {
    String name;
    SMS(String name) {
        this.name = name;
    }
}

public class Main {
    public static void main(String[] args) {
        Email email = new Email("Email");
        SMS sms = new SMS("SMS");
        Notifier emailNotifier = message -> System.out.println("Email: " + message);
        Notifier smsNotifier = message -> System.out.println("SMS: " + message);
        Notifier[] senders = { emailNotifier, smsNotifier  };
        String message = "Exam is tomorrow!";
        for (int i = 0; i < senders.length; i++) {
            senders[i].send(message);
            if (i == 0 && email instanceof Urgent) {
                senders[i].send(message);
            }
        }
    }
}