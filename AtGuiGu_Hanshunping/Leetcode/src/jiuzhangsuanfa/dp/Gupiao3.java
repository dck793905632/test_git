package jiuzhangsuanfa.dp;

import org.junit.Test;

import java.util.HashMap;

public class Gupiao3 {
    @Test
    public void test(){
        int[] prices= new int[]{3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(prices));

    }
    public int hammingWeight(int n) {
        int count=0;
        while(n!=0){
            count+=n&1;
            n>>>=1;//无符号右移
        }
        return count;
    }
    public int maxProfit(int[] prices) {
        int n =prices.length;
        if (n==0){
            return 0;
        }
        int[][] dp = new int[n+1][5+1];
        dp[0][1]=0;
        for (int i = 2; i <=5; i++) {
            dp[0][i]=Integer.MIN_VALUE;
        }
        for (int i = 1; i <=n; i++) {

            for (int j = 1; j <=5; j+=2) {
                dp[i][j]=dp[i-1][j];
                if (j>1 && i>=2 && dp[i-1][j-1]!=Integer.MIN_VALUE){
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-1]+prices[i-1]-prices[i-2]);
                }
            }

            for (int j = 2; j <=4; j+=2) {
                dp[i][j]=dp[i-1][j-1];
                if (i>=2 && dp[i-1][j]!=Integer.MIN_VALUE){
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j]+prices[i-1]-prices[i-2]);
                }
            }
        }
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return Math.max(dp[n][1],Math.max(dp[n][3],dp[n][5]));
    }
}
