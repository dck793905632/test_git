package jiuzhangsuanfa.dp;

public class GuPiao4 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n==0){
            return 0;
        }
        if (k>n/2){
            int sum=0;
            for (int i = 1; i <prices.length; i++) {
                if (prices[i]>prices[i-1]){
                    sum+=prices[i]-prices[i-1];
                }
            }
            return sum;
        }
        int[][] dp = new int[n+1][2*k+2];
        for (int i = 2; i <=2*k+1; i++) {
            dp[0][i]=Integer.MIN_VALUE;
        }

        for (int i = 1; i <=n; i++) {
            //1,3,5...2*k+1
            for (int j = 1; j <=2*k+1; j+=2) {
                dp[i][j]=dp[i-1][j];
                if (i>=2 && j>1 && dp[i-1][j-1]!=Integer.MIN_VALUE){
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-1]+prices[i-1]-prices[i-2]);
                }
            }
            //2,4...2*k
            for (int j = 2; j <=2*k; j+=2) {
                dp[i][j]=dp[i-1][j-1];
                if (i>=2 && dp[i-1][j]!=Integer.MIN_VALUE){
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j]+prices[i-1]-prices[i-2]);
                }
            }
        }

        int res = 0;
        for (int i = 1; i <=2*k+1; i+=2) {
            res=Math.max(res,dp[n][i]);
        }
        return res;

    }
}
