package com.atguigu.di2ji;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Phone implements Runnable{

    @Override
    public void run() {
        get();
    }

    private Lock lock = new ReentrantLock();
    public void get() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"   ");
            set();
        } finally {
            lock.unlock();
        }
    }
    public void set(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"   ");

        } finally {
            lock.unlock();
        }
    }
}
public class ReenterLockDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        Thread thread1 = new Thread(phone);
        Thread thread2 = new Thread(phone);
        thread1.start();
        thread2.start();
    }
}
