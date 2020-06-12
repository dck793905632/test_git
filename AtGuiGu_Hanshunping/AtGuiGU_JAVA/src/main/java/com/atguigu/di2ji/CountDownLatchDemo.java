package com.atguigu.di2ji;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 1; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"国被灭");
                countDownLatch.countDown();
            }, CountryEnum.countryEnum_forearch(i).getRetMessage()).start();
        }
        countDownLatch.await();
        System.out.println("一统华夏");
    }
}
