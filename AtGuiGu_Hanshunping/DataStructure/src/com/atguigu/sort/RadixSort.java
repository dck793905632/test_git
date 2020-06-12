package com.atguigu.sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr= {53,3,542,748,14,214};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr){
        //寻找最大的数
        int max=arr[0];
        for (int i=1;i<arr.length;i++){
            if (max<arr[i]){
                max=arr[i];
            }
        }
        //确定最大数的位数，循环次数
        int maxLength=(max+"").length();
        //声明桶大小
        int[][] bucket = new int[10][arr.length];
        //，每个桶存的数据数
        int[] bucketElementCount=new int[10];
        for (int i = 0,n=1; i < maxLength; i++,n*=10) {
            //现将数据存入桶中
            for (int j = 0; j <arr.length; j++) {
                int digitOfElement=arr[j]/n%10;
                bucket[digitOfElement][bucketElementCount[digitOfElement]]=arr[j];
                bucketElementCount[digitOfElement]++;
            }
            //从桶中取出再放回原数组
            int index =0;
            for (int k=0;k<bucketElementCount.length;k++){
                if (bucketElementCount[k]!=0){
                    for (int l=0;l<bucketElementCount[k];l++){
                        arr[index]=bucket[k][l];
                        index++;
                    }
                }
                bucketElementCount[k]=0;

            }
        }
    }
}
