package mayijinfu;

public class XX {
    public static void main(String[] args) {
        X x = new X();
        new Thread(() -> {
            x.A();
        }, "A").start();
        new Thread(() -> {
            x.B();
        }, "B").start();

    }

}

class X{
    public  synchronized static void A(){
        System.out.println("A");
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void B(){
        System.out.println("B");
        System.out.println(Thread.currentThread().getName());
    }

}
