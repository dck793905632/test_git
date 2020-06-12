package com.atguigu.di2ji;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class myThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("==========callable");
        return 1024;
    }
}



public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask<>(new myThread());

        Thread t = new Thread(futureTask);
        t.start();
        System.out.println(futureTask.get());
    }
}
