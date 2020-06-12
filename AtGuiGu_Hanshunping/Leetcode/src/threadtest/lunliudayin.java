package threadtest;

import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class lunliudayin {
    private int number = 1;
    private int i = 1;
    private int j = 2;
    private Lock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();

    public void print1() throws Exception{
        lock.lock();
        try {
            while (number!=1){
                c1.await();
            }
            System.out.println(Thread.currentThread().getName()+i);
            i+=2;
            number=2;
            c2.signal();
        } finally {
            lock.unlock();
        }
    }
    public void print2() throws Exception{
        lock.lock();
        try {
            while (number!=2){
                c2.await();
            }
            System.out.println(Thread.currentThread().getName()+j);;
            j+=2;
            number=1;
            c1.signal();
        } finally {
            lock.unlock();
        }

    }


    @Test
    public void test() throws Exception{
        new Thread(()->{
            try {
                for (int i = 0; i < 50; i++) {
                    print1();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"AA").start();
        new Thread(()->{
            try {
                for (int i = 0; i < 50; i++) {
                    print2();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"BB").start();
        Thread.sleep(10000);
    }
}
