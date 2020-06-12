package jiuzhangsuanfa.dp;

import org.junit.Test;

public class CountingBits {

    @Test
    public void test(){
        System.out.println(5&3);
        System.out.println(5%3);
    }
    public int[] countBits(int num) {
        int m = num;
        int[] dp = new int[m+1];
        dp[0]=0;
        for(int i=1;i<=m;i++){
            dp[i]=dp[i>>1]+i%2;
        }
        return dp;
    }
}
