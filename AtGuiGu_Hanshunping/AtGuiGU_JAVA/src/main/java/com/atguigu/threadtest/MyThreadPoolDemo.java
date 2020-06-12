package com.atguigu.threadtest;

import javax.print.attribute.HashPrintJobAttributeSet;
import java.util.HashMap;
import java.util.concurrent.*;
import java.util.function.Consumer;

public class MyThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                3L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        Executors.newFixedThreadPool(1,Executors.defaultThreadFactory());
        Executors.newCachedThreadPool(Executors.defaultThreadFactory());
        Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());

        try {
            for (int i = 1; i <=10; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t办理业务");
                        });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        StringBuilder stringBuilder =new StringBuilder();
        stringBuilder.append("a");


    }


}
