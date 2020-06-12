package com.atguigu.test;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SharData{
    private int num=1;
    private Lock lock = new ReentrantLock();

    private Condition cd1 = lock.newCondition();
    private Condition cd2 = lock.newCondition();
    private Condition cd3 = lock.newCondition();

    public void print5(int total){
        lock.lock();
        try {
            while (num!=1){
                cd1.await();
            }
            for (int i = 1; i <=5 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+total+"\t"+i);
            }
            num=2;
            cd2.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print10(int total){
        lock.lock();
        try {
            while (num!=2){
                cd2.await();
            }
            for (int i = 1; i <=10 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+total+"\t"+i);
            }
            num=3;
            cd3.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15(int total){
        lock.lock();
        try {
            while (num!=3){
                cd3.await();
            }
            for (int i = 1; i <=15 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+total+"\t"+i);
            }
            num=1;
            cd1.signal();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}
public class ThreadOrderAccess {
    public static void main(String[] args) {

        SharData sharData = new SharData();

        new Thread(()->{
            for (int i=1;i<=10;i++){
                sharData.print5(i);
            }
        },"AA").start();
        new Thread(()->{
            for (int i=1;i<=10;i++){
                sharData.print10(i);
            }
        },"BB").start();
        new Thread(()->{
            for (int i=1;i<=10;i++){
                sharData.print15(i);
            }
        },"CC").start();
    }
}
