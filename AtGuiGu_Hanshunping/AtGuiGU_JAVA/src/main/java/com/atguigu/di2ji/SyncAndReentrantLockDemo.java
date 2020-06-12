package com.atguigu.di2ji;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareResource{
    private int number = 1;
    private Lock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();

    public void print5() throws Exception{
        lock.lock();
        try {
            while (number!=1){
                c1.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName());
            }
            number=2;
            c2.signal();
        } finally {
            lock.unlock();
        }
    }
    public void print10() throws Exception{
        lock.lock();
        try {
            while (number!=2){
                c2.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName());
            }
            number=3;
            c3.signal();
        } finally {
            lock.unlock();
        }

    }
    public void print15() throws Exception{
        lock.lock();
        try {
            while (number!=3){
                c3.await();
            }
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName());
            }
            number=1;
            c1.signal();
        } finally {
            lock.unlock();
        }

    }
}

public class SyncAndReentrantLockDemo {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    shareResource.print5();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "AA").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    shareResource.print10();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "BB").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    shareResource.print15();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "CC").start();
    }
}
