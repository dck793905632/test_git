package com.atguigu.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 23, -567, 0};
        //int[] arr = {6,3,7,9,6,1,4,8};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }
    public static void quickSort(int[] arr, int left, int right) {
        if (left>right){
            return;
        }
        int i=left;
        int j=right;
        int base = arr[left];
        while (i!=j){
            while (arr[j]<=base && i<j){
                j--;
            }
            while (arr[i]>=base && i<j){
                i++;
            }

            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
        arr[left]=arr[i];
        arr[i]=base;

        quickSort(arr,left,i-1);
        quickSort(arr,j+1,right);
    }
    /*public static void quickSort(int[] arr, int left, int right) {
        //如果左索引比右索引大，直接返回
        if (left>right){
            return;
        }
        //定义i，指向左边
        int i=left;
        //定义j，指向右边
        int j=right;
        //定义基准数
        int base = arr[left];
        while (i!=j){
            //从右边开始找，找比base小的数，i<j防止越界
            while (arr[j]>=base && i<j){
                j--;
            }
            //从左边开始找，找比base大的数.i<j防止越界
            while (arr[i]<=base && i<j){
                i++;
            }
            //交换i,j位置的数据
            int temp = arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
        //当前i==j,此时交换基准数与i处的数据
        arr[left]=arr[i];
        arr[i]=base;
        //左半部分递归调用
        quickSort(arr,left,i-1);
        //右半部分递归调用
        quickSort(arr,j+1,right);
    }*/
    /*public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left+right)/2];
        int temp=0;
        while (l<r){
            while (arr[l]<pivot){
                l++;
            }
            while (arr[r]>pivot){
                r--;
            }

            if (l>=r){
                break;
            }

            temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;

            if (arr[l]==pivot){
                r--;
            }
            if (arr[r]==pivot){
                l++;
            }
        }
        if (l==r){
            l++;
            r--;
        }
        if (left<r){
            quickSort(arr,left,r);
        }
        if (l<right){
            quickSort(arr,l,right);
        }

    }*/

}
