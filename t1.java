public class t1 {
public static class A { 

        public int getA() { 

            return 5; 

        } 

    } 

    public static class B extends A { 

        public int getA() { 

            return 10; 

        } 

        public int getB() { 

            return 15; 

        } 

    } 

    public static void main(String[] args) { 

        A a1 = new A(); 

        B b1 = new B(); 

        System.out.printf("AA: %d, BA: %d, BB: %d\n", a1.getA(), b1.getA(), b1.getB()); 

    } 

}