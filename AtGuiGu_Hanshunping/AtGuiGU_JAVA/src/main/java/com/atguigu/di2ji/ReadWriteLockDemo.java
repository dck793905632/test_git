package com.atguigu.di2ji;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyCaChe{
    private volatile Map<String ,Object> map = new HashMap<>();
    private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    public void put(String key,Object value){
        reentrantReadWriteLock.writeLock().lock();
            try {
                System.out.println("正在写入："+key);
                try {
                    TimeUnit.MICROSECONDS.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                map.put(key,value);
                System.out.println("写入成功");
            } finally {
                reentrantReadWriteLock.writeLock().unlock();
            }
    }

    public void get(String key){
        reentrantReadWriteLock.readLock().lock();
            try {
                System.out.println("正在获取数据");
                try {
                    TimeUnit.MICROSECONDS.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Object result = map.get(key);
                System.out.println("获取数据："+result);
            } finally {
                reentrantReadWriteLock.readLock().unlock();
            }

    }
    public void clearCaChe(){
        map.clear();
    }
}
public class ReadWriteLockDemo {
    public static void main(String[] args) {
         MyCaChe myCaChe = new MyCaChe();

        for (int i = 0; i < 5; i++) {
            final int temp =i;
            new Thread(() -> {
                myCaChe.put(temp+"",temp);
            }, String.valueOf(i)).start();
        }

        for (int i = 0; i < 5; i++) {
            final int temp =i;
            new Thread(() -> {
                myCaChe.get(temp+"");
            },String.valueOf(i) ).start();

        }
    }
}
