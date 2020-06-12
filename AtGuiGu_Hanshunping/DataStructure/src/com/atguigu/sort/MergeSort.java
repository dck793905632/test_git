package com.atguigu.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr= {8,4,5,7,1,3,6,2};
        int[] temp = new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }
    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if (left<right){
            int mid=(left+right)/2;
            mergeSort(arr,left,mid,temp);
            mergeSort(arr,mid+1,right,temp);
            merge(arr,left,mid,right,temp);
        }

    }

    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i=left;//从左边开始下标
        int j=mid+1;//从右边开始下标
        int t=0;//temp开始下标

        //从左边和右边开始比较，一次写入temp
        while(i<=mid && j<=right){
            if (arr[i]<=arr[j]){
                temp[t]=arr[i];
                i+=1;
                t+=1;
            }else {
                temp[t]=arr[j];
                t+=1;
                j+=1;
            }
        }

        //如果左边没写完
        while (i<=mid){
            temp[t]=arr[i];
            t+=1;
            i+=1;
        }

        //如果右边没有写完
        while (j<=right){
            temp[t]=arr[j];
            t+=1;
            j+=1;
        }

        //将temp重新写入arr
        t=0;
        int tempLeft=left;
        while (tempLeft<=right){
            arr[tempLeft]=temp[t];
            t+=1;
            tempLeft+=1;
        }
    }
}
