package mayijinfu;

public class Main {
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(6000);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();
        System.out.println("main");

        StringBuilder stringBuilder = new StringBuilder();
        StringBuffer stringBuffer = new StringBuffer();
    }
}
