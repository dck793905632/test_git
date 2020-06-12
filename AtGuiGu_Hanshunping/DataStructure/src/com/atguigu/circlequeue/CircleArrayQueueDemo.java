package com.atguigu.circlequeue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        System.out.println("测试数组模拟环形队列~~~~");
        CircleArrayQueue queue = new CircleArrayQueue(4);
        char key;
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (true) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出");
            System.out.println("a(add):添加数据");
            System.out.println("g(get):获得数据");
            System.out.println("h(head):获得头");
            key = scanner.next().charAt(0);
            switch (key) {
                case 'e':
                    break;
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入：");
                    Scanner scanner1 = new Scanner(System.in);
                    int n = scanner1.nextInt();
                    queue.addQueue(n);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.println("数据为：" + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.getHead();
                        System.out.println("对头数据为：" + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }


        }

    }

}

class CircleArrayQueue{
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleArrayQueue(int maxSize){
        this.maxSize=maxSize;
        this.front=0;
        this.rear=0;
        this.arr=new int[maxSize];
    }
    //判断队列是否满
    public boolean isFull(){
        return (rear+1)%maxSize==front;
    }
    //判断队列是否空
    public boolean isEmpty(){
        return rear==front;
    }
    //向队列中添加数据
    public void addQueue(int n){
        if (isFull()){
            System.out.println("队列已满！");
            return;
        }
        arr[rear]=n;
        rear=(rear+1)%maxSize;
    }
    //获取队列数据
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，无法获取数据");
        }
        int value = arr[front];
        front=(front+1)%maxSize;
        return value;
    }
    //获取队列头数据
    public int getHead(){
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法获取数据");
        }
        return arr[front];
    }
    //展示环形队列
    public void showQueue(){
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法获取数据");
        }
        for (int i =front;i<front+size();i++){
            System.out.printf("arr[%d]=%d",i%maxSize,arr[i%maxSize]);
        }
    }
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }
}
