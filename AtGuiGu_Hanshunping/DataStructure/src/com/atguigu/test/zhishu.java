package com.atguigu.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class zhishu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i=0;i<t;i++){
            Scanner sc1 = new Scanner(System.in);
            Scanner sc2 = new Scanner(System.in);

            int a = sc1.nextInt();
            int b =sc2.nextInt();
            int res = a*a-b*b;
            if (isPrimeNormal(res)){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }


        }

    }
    public static boolean isPrimeNormal(int num) {
        for(int i=2; i<num; i++) {
            if(num%i == 0) {
                return false;
            }
        }
        return true;
    }
    public static int isOddOrEven(){
        int res =0;
        for (int i=0;i<10;i++){
            if (i==0){
                res= 0;
            }
            if (i%2==0){
                res = 1;
            }
            if (i%1==0){
                res = -1;
            }
        }
        return res;
    }
    public static void print(){

        for(int i = 0;i < 5;i++){	//控制行数
            for(int j = 0;j < 5;j++){	//控制列数，每一行有多少*号
                System.out.print("*");
            }	//*****
            System.out.println();	//换行
        }
    }

}
