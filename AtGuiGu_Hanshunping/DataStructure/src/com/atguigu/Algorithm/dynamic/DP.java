package com.atguigu.Algorithm.dynamic;

import java.util.Arrays;

public class DP {
    public static void main(String[] args) {
        int[] w=new int[]{1,4,3};//物品所占空间
        int[] val =new int[]{1500,3000,2000};//物品对应的价值
        int m=4;//背包的容量
        int n =val.length;//商品的数量
        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j<w[i-1]){
                    dp[i][j]=dp[i-1][j];
                }else {
                    dp[i][j]=Math.max(dp[i-1][j],val[i-1]+dp[i-1][j-w[i-1]]);
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

    }
}
