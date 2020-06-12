package jiuzhangsuanfa.dp;

import org.junit.Test;

import java.util.Arrays;

public class GuPiao1 {
    @Test
    public void test(){
        int[] A = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(A));
    }
    public int maxProfit(int[] A){
        if (A.length==0){
            return 0;
        }
        int minVal = A[0];
        int res =0;
        int[] dp = new int[A.length];
        dp[0]=0;
        for (int i = 1; i < A.length; i++) {
            dp[i]=Math.max(res,A[i]-minVal);
            res= Math.max(res,A[i]-minVal);
            minVal=Math.min(minVal,A[i]);
        }

        System.out.println(Arrays.toString(dp));
        return res;
    }
}
