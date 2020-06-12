package medium;

import org.junit.Test;

public class medium55 {
    @Test
    public void test(){
        int[] nums = new int[]{1,2,0,1,4};
        System.out.println(canJump(nums));
    }
    public boolean canJump(int[] nums) {
        if(nums.length==1){
            return true;
        }
        int right = nums[0];
        for (int i = 0; i <=right; i++) {
            if (i+nums[i]>=nums.length-1){
                return true;
            }
            if (i+nums[i]>right){
                right=i+nums[i];
            }
        }
        return false;
    }
    /*public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0]=true;

        for(int j=1;j<n;j++){
            dp[j]=false;
            for(int i=0;i<=j;i++){
                if(dp[i] && nums[i]+i>=j){
                    dp[j]=true;
                    break;
                }
            }
        }
        return dp[n-1];
    }*/
}
