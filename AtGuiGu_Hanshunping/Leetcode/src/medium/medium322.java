package medium;

import org.junit.Test;

public class medium322 {
    @Test
    public void test(){
        int[] coins=new int[]{2};
        System.out.println(coinChange(coins,3));
    }
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount+1];
        for (int i = 0; i <=amount ; i++) {
            dp[i]=amount+1;
        }
        dp[0]=0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j<coins.length; j++) {
                if (i-coins[j]>=0){
                    dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount]>amount ? -1 : dp[amount];
    }
}
