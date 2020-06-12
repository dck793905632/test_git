package com.atguigu.di2ji;

import java.util.*;
import java.util.concurrent.*;

class SortData{
    private volatile boolean flag= true;
    private BlockingQueue<Integer> blockingQueue=null;
    private List<Integer> list = new CopyOnWriteArrayList<>();

    public SortData(BlockingQueue<Integer> blockingQueue){
        this.blockingQueue=blockingQueue;
    }

    public void myPro() throws Exception{
        int random;
        while (flag){
            random=(int)(Math.random()*101);
            blockingQueue.put(random);
            TimeUnit.SECONDS.sleep(1);
        }
    }

    public void myConsummer() throws Exception{
        int result;
        while (flag){
            result=blockingQueue.take();
            list.add(result);
            Collections.sort(list);
        }
    }

    public void stop(){
        flag=false;
    }

    public void printList(){
        System.out.println(list);
        System.out.println(list.size());
    }
}


public class ProConsummer_Listzijietiaodong {
    public static void main(String[] args) throws InterruptedException {
        SortData sortData = new SortData(new ArrayBlockingQueue<Integer>(100));
        new Thread(() -> {
            try {
                    sortData.myPro();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "pro").start();

        new Thread(() -> {
            try {

                    sortData.myConsummer();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "consummer").start();


        TimeUnit.SECONDS.sleep(5);
        sortData.stop();
        sortData.printList();
    }
}