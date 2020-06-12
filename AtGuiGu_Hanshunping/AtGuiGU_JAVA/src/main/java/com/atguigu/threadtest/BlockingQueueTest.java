package com.atguigu.threadtest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueTest{
    public static void main(String[] args) throws InterruptedException {
        BlockingQueueTest1 bl = new BlockingQueueTest1(5);
        new Thread(() -> {
            try {
                bl.add();
                bl.add();
                bl.add();
                bl.add();
                bl.add();
                bl.add();
                bl.add();
                bl.add();
                bl.add();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "a").start();
        new Thread(() -> {
            try {
                while (true){
                    bl.take();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "b").start();
        Thread.sleep(2);
    }
}
class BlockingQueueTest1 {
    private final int capacity;

    private ReentrantLock lock = new ReentrantLock();

    private Condition full = lock.newCondition();
    private Condition empty = lock.newCondition();

    private Queue<Integer> queue;

    private volatile int count=0;

    public BlockingQueueTest1(int capacity) {
        this.capacity = capacity;
        queue=new LinkedList();
    }

    public void add() throws InterruptedException {
        lock.lock();
        try {
            while (capacity==count){
                full.await();
                System.out.println("满了");
            }
            queue.offer(1);
            count++;
            empty.signal();
        } finally {
            lock.unlock();
        }

    }

    public void take() throws InterruptedException {
        lock.lock();
        try {
            while(count==0){
                empty.await();
            }
            int poll = queue.poll();
            count--;
            full.signal();
            System.out.println(poll);
        } finally {
            lock.unlock();
        }

    }

}
