package thread;

import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ABC {
    private int number=1;
    private Lock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();
    @Test
    public void test() throws Exception{
        new Thread(()->{
            try {
                print5();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                print10();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                print15();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
    public void print5() throws Exception{
        lock.lock();
        try{
            while(number!=1){
                c1.await();
            }
            System.out.println("A");
            c2.signal();
            number=2;
        }finally{
            lock.unlock();
        }

    }
    public void print10() throws Exception{
        lock.lock();
        try{
            while (number!=2){
                c2.await();
            }
            System.out.println("B");
            c3.signal();
            number=3;
        }finally{
            lock.unlock();
        }
    }
    public void print15() throws Exception{
        lock.lock();
        try {
            while (number!=3){
                c3.await();
            }
            System.out.println("C");
            c1.signal();
            number=1;
        }finally{
            lock.unlock();
        }
    }
}
