package com.atguigu.test;

public class NowTest {
    public static void main(String[] args) {
        String str ="+";
        if (str=="+"){
            System.out.println("r");
        }

    }

    public int max(int a,int b,int c){
        int temp=0;
        if(a<b){
            temp= b;
        }
        if(b<c){
            temp= c;
        }
        if(a<c) {
            temp= c;
        }
        int f='a';
        return temp;
    }


}
