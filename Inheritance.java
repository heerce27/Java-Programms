class Bank {
    protected float rate;
    Bank(float rate) {
        this.rate = rate;
    }
}
class Branch extends Bank {
    protected int time;
    Branch(float rate, int time) {
        super(rate);
        this.time = time;
    }
}
class Client extends Branch {
    int principal;
    Client(float rate, int time, int principal) {
        super(rate, time);
        this.principal = principal;
    }
    void calculate() {
        float si = (principal * rate * time) / 100;
        System.out.println("Simple Interest = " + si);
    }
}

public class Inheritance {
    public static void main(String[] args) {
        Client c = new Client(10, 2, 10000);
        c.calculate();
    }
}