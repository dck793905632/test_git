package simple;

public class simple53 {
    public static void main(String[] args) {
        int[] arr ={-2,1,-3};
        int i = maxSubArray(arr);
        System.out.println(i);
    }
    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0]=nums[0];
        int max=dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i]= Math.max(nums[i], dp[i-1]+nums[i]);
            if (max<dp[i]){
                max=dp[i];
            }
        }
        return max;
    }
}
