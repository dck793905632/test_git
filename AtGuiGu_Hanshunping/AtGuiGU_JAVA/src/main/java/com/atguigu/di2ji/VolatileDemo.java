package com.atguigu.di2ji;

import java.util.concurrent.atomic.AtomicInteger;

class MyData{
    volatile int number=0;
    public  void addPlusPlus(){
        number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();

    public void addMyatomic(){
        atomicInteger.getAndIncrement();
    }
}
public class VolatileDemo {
    public static void main(String[] args) {
        MyData myData =new MyData();
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j=0;j<1000;j++){
                    myData.addPlusPlus();
                    myData.addMyatomic();
                }
            },String.valueOf(i)).start();
        }
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+" "+myData.number);
        System.out.println(Thread.currentThread().getName()+" "+myData.atomicInteger);
    }
}
