package com.atguigu.queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        //创建一个队列
        ArrayQueue queue = new ArrayQueue(3);
        boolean loop=true;
        char key;
        Scanner scanner = new Scanner(System.in);
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出");
            System.out.println("a(add):添加数据");
            System.out.println("g(get):获得数据");
            System.out.println("h(head):获得头");
            key=scanner.next().charAt(0);
            switch (key){
                case 'e':
                    break;
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入：");
                    Scanner scanner1= new Scanner(System.in);
                    int n = scanner1.nextInt();
                    queue.addQueue(n);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.println("数据为："+res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.println("对头数据为："+res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }


        }
        System.out.println("程序退出");

    }

}
class ArrayQueue{
    private int maxSize;//队列长度
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//模拟队列数组

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = -1;
        this.rear = -1;
        this.arr = new int[maxSize];
    }

    //判断队列是否满
    public boolean isFull(){
        return rear== maxSize-1;
    }
    //判断队列是否空
    public boolean isEmpty(){
        return front==rear;
    }

    //向队列添加信息
    public void addQueue(int n){
        //判断队列是否满
        if(isFull()){
            System.out.println("队列已满");
            return;
        }
        rear++;
        arr[rear]=n;
    }
    //获取队列数据，出队
    public int getQueue(){
        if (isEmpty()){
            rear=-1;
            front=-1;
            throw new RuntimeException("队列为空，无法获取数据");
        }
        front++;
        int res= arr[front];
        arr[front]=0;
        return res;
    }
    //显示所有队列
    public void showQueue(){
        //判断队列是否为空
        if(isEmpty()) {
            rear=-1;
            front=-1;
            System.out.println("队列为空，没有数据");
            return;
        }
        for (int i=0;i<arr.length;i++){
            System.out.printf("arr[%d]=%d",i,arr[i]);
            System.out.println();
        }
    }
    //获取队列头，不是取出数据
    public int headQueue(){
        if (isEmpty()){
            rear=-1;
            front=-1;
            throw  new RuntimeException("队列为空，无法获取对头数据");
        }
        return arr[front+1];
    }

}
