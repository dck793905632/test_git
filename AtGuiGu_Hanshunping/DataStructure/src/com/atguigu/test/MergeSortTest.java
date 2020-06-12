package com.atguigu.test;

import org.junit.Test;

public class MergeSortTest {
    @Test
    public void test(){
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 50 };
        sortArray(a);
        System.out.println("排好序的数组：");
        for (int e : a)
            System.out.print(e+" ");
    }
    public int[] sortArray(int[] nums) {
        int[] temp = new int[nums.length];
        mergeSort(nums,0,nums.length-1,temp);
        return nums;
    }

    //拆分，递归
    public void mergeSort(int[] arr,int left,int right,int[] temp){
        if(left<right){
            int mid = (left+right)/2;
            //往左递归
            mergeSort(arr,left,mid,temp);
            //往右递归
            mergeSort(arr,mid+1,right,temp);
            //合并
            merge(arr,left,mid,right,temp);
        }
    }
    //合并
    //arr 原数组 ，left左下标，mid中间值，right右下标，temp额外空间数组
    public void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i=left;//前半段有序的开始下标
        int j=mid+1;//后半段有序的开始下标
        int t=0; //往temp放数据，temp的下标

        //先把左右两边的有序序列进行处理，直到有一边处理完毕
        while(i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[t]=arr[i];
                i++;
                t++;
            }else{
                temp[t]=arr[j];
                j++;
                t++;
            }
        }
        //将没有处理完的一边数据写入temp
        while(i<=mid){
            temp[t]=arr[i];
            i++;
            t++;
        }
        while(j<=right){
            temp[t]=arr[j];
            j++;
            t++;
        }
        //将temp的数据写回原数组
        //第一次 left 0 right 1,第二次 left 2 right 3...
        //最后一次，也就是length-1次 left 0 right length-1;
        t=0;
        for(int k=left;k<=right;k++){
            arr[k]=temp[t];
            t++;
        }
    }






}
