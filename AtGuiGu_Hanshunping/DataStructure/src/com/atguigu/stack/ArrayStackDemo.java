package com.atguigu.stack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        boolean loop=true;
        ArrayStack stack = new ArrayStack(4);
        String key ="";
        Scanner scanner = new Scanner(System.in);
        while (loop){
            System.out.println("show"+"遍历栈");
            System.out.println("push"+"入栈");
            System.out.println("pop"+"出栈");
            System.out.println("exit"+"退出");
            key=scanner.nextLine();
            switch(key){
                case "show":
                    stack.list();
                    break;
                case "push":
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    int value1=stack.pop();
                    System.out.println(value1);
                    break;
                case "exit":
                    loop=false;
                    break;
                default:
                    break;
            }


        }
    }
}

class ArrayStack{
    private int top=-1;
    private int[] stack;
    private int maxSize;

    public ArrayStack(int maxSize){
        this.maxSize=maxSize;
        stack=new int[maxSize];
    }

    //判断栈满
    public boolean isFull(){
        return top==maxSize-1;
    }
    //判断栈空
    public boolean isEmpty(){
        return top==-1;
    }
    //入栈
    public void push(int value){
        if (isFull()){
            System.out.println("栈满，不能入栈");
            return;
        }
        top++;
        stack[top]=value;
    }
    //出栈
    public int pop(){
        if (isEmpty()){
            throw  new RuntimeException("栈空，没有数据");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈
    public void list(){
        if (isEmpty()){
            System.out.println("没有数据");
            return;
        }
        for (int i =top;i>0;i--){
            System.out.println(stack[i]);
        }
    }

}

