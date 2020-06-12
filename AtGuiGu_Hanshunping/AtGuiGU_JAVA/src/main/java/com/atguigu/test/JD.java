package com.atguigu.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

public class JD {
    @Test
    public void test(){
        Set<Integer> set = new TreeSet<>();
        set.add(2);
        set.add(1);
        set.add(8);
        set.add(4);
        System.out.println(set);

    }
    public int res(int[] arr){
        int length = arr.length;
        if(length==0){
            return 0;
        }
        int resNum = Integer.MIN_VALUE;
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            dp[i]=1;
            if(i>0 && arr[i]>arr[i-1]){
                dp[i]=dp[i-1]+1;
            }
            resNum=Math.max(resNum,dp[i]);
        }
        return resNum;
    }
}
