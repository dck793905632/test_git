package jiuzhangsuanfa.dp;

import org.junit.Test;

public class Dandiaoshulie {
    @Test
    public void test(){
        int[] nums = new int[]{1,3,5,3,2,1,4,7};
        System.out.println(longestIncreasingContinuousSubsequence(nums));
    }
    public int longestIncreasingContinuousSubsequence(int[] nums){
        int n =nums.length;
        if (n==0){
            return 0;
        }
        int r1 =LICS(nums,n);

        int i=0;
        int j =n-1;
        while (i<j){
            int temp = nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
        int r2 = LICS(nums,n);
        return Math.max(r1,r2);
    }
    public int LICS(int[] nums ,int n){
        int[] dp = new int[n];
        int res = 0;
        for (int i = 0; i <n; i++) {
            dp[i]=1;
            if (i>0 && nums[i]>nums[i-1]){
                dp[i]=dp[i-1]+1;
            }
            res =Math.max(res,dp[i]);
        }
        return res;
    }

}
