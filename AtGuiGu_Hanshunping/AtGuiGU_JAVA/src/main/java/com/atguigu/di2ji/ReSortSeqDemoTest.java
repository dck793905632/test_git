package com.atguigu.di2ji;

class ReSortSeqDemo {
    int a=0;
    boolean flag =false;

    public void method1(){
        a=1;
        flag=true;
    }
    public void method2(){
        if (flag){
            a=a+500000;
            System.out.println("============="+a);
        }
    }
}

public class ReSortSeqDemoTest{
    public static void main(String[] args) {
        ReSortSeqDemo reSortSeqDemo = new ReSortSeqDemo();

        for (int i=0;i<100;i++){
            new Thread(()->{
                for (int j=0;j<100;j++){
                    reSortSeqDemo.method1();
                    reSortSeqDemo.method2();
                }
            },String.valueOf(i)).start();
        }
    }
}