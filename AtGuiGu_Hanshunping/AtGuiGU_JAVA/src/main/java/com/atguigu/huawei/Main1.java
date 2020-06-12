package com.atguigu.huawei;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        /*Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = scanner.nextInt();
        }*/
        String[]  arr=new String[]{"1","2","3"};
        outAll(Arrays.asList(arr),"");

    }
    public static void outAll(List aList,String temp){
        System.out.println(temp);

        for(int i=0;i<aList.size();i++){
            List tempList=new LinkedList(aList);
            outAll(tempList, temp+tempList.remove(i));
        }
    }




}
