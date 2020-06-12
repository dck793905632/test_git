package com.atguigu.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareDataOne {

    private static int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition cd = lock.newCondition();

    public void incr(){
        lock.lock();
        try {
            while (number!=0){
                cd.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName()+":"+number);
            cd.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void decr(){
        lock.lock();
        try {
            while (number!=1){
                cd.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+":"+number);
            cd.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

//    public synchronized   void incr() throws InterruptedException {
//        while (number!=0){
//            this.wait();
//        }
//
//        number++;
//        System.out.println(Thread.currentThread().getName()+":"+number);
//
//        this.notifyAll();
//    }
//
//    public  synchronized void decr() throws InterruptedException {
//        while (number!=1){
//            this.wait();
//        }
//
//        number--;
//        System.out.println(Thread.currentThread().getName()+":"+number);
//
//        this.notifyAll();
//    }
}

/**
 * 现在两个线程
 * 操作一个初始值为0的变量
 * 实现一个线程对变量增加1，一个线程对变量减少1
 * 交替，来10轮
 * 、线程 操作 资源类 2、高内聚低耦合
 * 1、判断
 * 2、干活
 * 3、通知
 *
 * 注意多线程之间的虚假唤醒
 */
public class NotifyWaitDemo {


    public static void main(String[] args) {
        ShareDataOne shareDataOne = new ShareDataOne();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {

                shareDataOne.incr();
            }
        }, "AA").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                shareDataOne.decr();
            }
        }, "BB").start();
    }
}
