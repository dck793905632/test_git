package com.atguigu.di2ji;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPoolDemo {

    static ReentrantLock reentrantLock = new ReentrantLock();
    public static void main(String[] args) {
        //ExecutorService executorService = Executors.newFixedThreadPool(2);
        ExecutorService executorService = Executors.newCachedThreadPool();
        reentrantLock.lock();
        reentrantLock.unlock();
    }
}
