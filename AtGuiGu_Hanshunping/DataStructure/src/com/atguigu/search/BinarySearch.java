package com.atguigu.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        //int[] arr = {1,3,5,6,7,8,9,10};
        int[] arr = {1,8,10,89,1000,1000,1001,1011};
        //Arrays.sort(arr);
        List<Integer> list = binarySearch2(arr, 0, arr.length - 1, 1000);
        System.out.println(list);
    }
    public static int binarySearch(int[] arr,int left,int right,int findVal){
        //中间值下标值
        int mid=(left+right)/2;
        //取出中间值
        int midVal=arr[mid];
        if (left>right){
            return -1;
        }

        if (midVal<findVal){
            //右递归
            return binarySearch(arr,mid+1,right,findVal);
        }else if (midVal>findVal){
            //左递归
            return binarySearch(arr,left,mid-1,findVal);
        }else {
            return mid;
        }
    }


    public static List<Integer> binarySearch2(int[] arr,int left,int right,int findVal){
        //中间值下标值
        int mid=(left+right)/2;
        //取出中间值
        int midVal=arr[mid];
        if (left>right){
            return new ArrayList<>();
        }

        if (midVal<findVal){
            //右递归
            return binarySearch2(arr,mid+1,right,findVal);
        }else if (midVal>findVal){
            //左递归
            return binarySearch2(arr,left,mid-1,findVal);
        }else {
            List<Integer> resIndexList=new ArrayList<>();
            int temp=mid-1;
            while (true){
                if (temp<0 ||arr[temp]!=findVal){
                    break;
                }
                //mid左边的数据入list
                resIndexList.add(temp);
                temp--;
            }
            resIndexList.add(mid);
            temp=mid+1;
            while (true){
                if (temp>arr.length-1 || arr[temp]!=findVal){
                    break;
                }
                resIndexList.add(temp);
                temp++;
            }
            return resIndexList;
        }
    }
}
