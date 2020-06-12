package jiuzhangsuanfa.dp;

public class JumpGames {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0]=true;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(nums[j]+j>=i && dp[j]){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[nums.length-1];
    }
}
