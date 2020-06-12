package simple;

import org.junit.Test;

public class simple674 {
    @Test
    public void test(){
        int[] nums = new int[]{1,3,5,4,7};
        System.out.println(findLengthOfLCIS(nums));

    }
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        if(n==0){
            return 0;
        }
        int res =0;
        int[] dp = new int[n];
        for(int i=0;i<n;i++){
            dp[i]=1;
            if(i>0 && nums[i]>nums[i-1]){
                dp[i]=dp[i-1]+1;
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
