package com.atguigu.di2ji;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareData1{
    private int number=0;
    //private Lock lock = new ReentrantLock();
    //private Condition condition =lock.newCondition();
    public synchronized void increment() throws  Exception{

        try {
            while (number!=0){
                //阻塞
                this.wait();
            }
            number++;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            this.notifyAll();
        } finally {

        }
    }

    public synchronized void decrement() throws Exception{

        try {
            while (number==0){
                this.wait();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"\t"+number);
            this.notifyAll();
        } finally {
        }

    }
}

public class ProCommer01 {
    public static void main(String[] args) {
        ShareData1 shareData1 = new ShareData1();

        new Thread(() -> {
            for (int i = 1; i <=5; i++) {
                try {
                    shareData1.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "AA").start();

        new Thread(() -> {
            for (int i = 1; i <=5; i++) {
                try {
                    shareData1.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "BB").start();
    }

}
