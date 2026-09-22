class Mult extends Thread{
   
    public void run(){
       
        for(int i=1;i<=10;i++){
        if(i%3==0){
            int n=i*5;
             System.out.println(Thread.currentThread().getName() + " : " + i + " * 5 = " + n);
        }
    }
}
}

class Runex2 implements Runnable {
    public void run(){
        for(int i=1;i<=20;i++){
        if(i%7==0){
             System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
    } 
}

class Runex3 implements Runnable{
    public void run(){
        for(int i=1;i<=10;i++){
        if(i%5==0){
            int n=i*2;
            System.out.println(Thread.currentThread().getName() + " : " + i + " * 2 = " + n);
        }
    }
    }
}
public class Threadex_c1 {
    public static void main(String[] args) {
        Mult m1 = new Mult();
        m1.setName("Dhoni");

        Runex2 r2 = new Runex2();
        Thread m2 = new Thread(r2);
        m2.setName("Yuvraj");

        // Third thread - implements Runnable
        Runex3 r3 = new Runex3();
        Thread m3 = new Thread(r3);
        m3.setName("Virat");
        m1.start();
        m2.start();
        m3.start();
    }
}
