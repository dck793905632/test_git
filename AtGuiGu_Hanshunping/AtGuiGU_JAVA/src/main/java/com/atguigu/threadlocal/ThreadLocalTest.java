package com.atguigu.threadlocal;

public class ThreadLocalTest {
    static ThreadLocal<Integer> threadLocal = new ThreadLocal();

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(threadLocal.get());
            threadLocal.set(0);
            System.out.println(threadLocal.get());
        }, "").start();
        new Thread(() -> {
            System.out.println(threadLocal.get());
            threadLocal.set(1);
            threadLocal.remove();
            System.out.println(threadLocal.get());
        }, "").start();

    }
}
