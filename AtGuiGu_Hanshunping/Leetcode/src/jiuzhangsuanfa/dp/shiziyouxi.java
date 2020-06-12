package jiuzhangsuanfa.dp;

public class shiziyouxi {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        if(n==0){
            return false;
        }
        if(n==1){
            return true;
        }
        boolean[] dp = new boolean[n+1];
        dp[0]=false;
        dp[1]=true;

        for(int i=2;i<=n;i++){
            dp[i]=(!dp[i-1]) || (!dp[i-2]);
        }
        return dp[n];
    }
}
