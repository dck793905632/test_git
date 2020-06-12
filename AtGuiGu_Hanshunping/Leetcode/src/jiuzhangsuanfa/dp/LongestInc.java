package jiuzhangsuanfa.dp;

import org.junit.Test;

public class LongestInc {
    @Test
    public void test(){
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n==0){
            return 0;
        }
        int[] dp = new int[n];
        int res=0;
        for(int j=0;j<n;j++){
            dp[j]=1;
            for(int i=0;i<j;i++){
                if(nums[i]<nums[j]){
                    dp[j]=Math.max(dp[i]+1,dp[j]);
                }
            }
            res = Math.max(dp[j],res);
        }
        return res;
    }
}
