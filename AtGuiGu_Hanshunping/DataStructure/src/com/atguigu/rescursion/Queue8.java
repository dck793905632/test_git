package com.atguigu.rescursion;

public class Queue8 {
    private int Max=8;
    private int[] array=new int[Max];
    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);

    }

    //放置第几个皇后
    public void check(int n){
        if (n==Max){
            print();
            return;
        }
        for (int i=0;i<Max;i++){
            array[n]=i;
            if (judge(n)){
                check(n+1);
            }
        }
    }
    //判断
    public boolean judge(int n){
        for (int i=0;i<n;i++){
            if (array[i]==array[n]||Math.abs(n-i)==Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }
    //打印
    public void print(){
        for (int i = 0; i <8 ; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}
