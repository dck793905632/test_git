package simple;

public class simple198 {

    /*
    *
    *
    * 打家劫舍这一类问题分别在No198，No213和No337，本题是这一类问题最简单的一种状态，第一直觉就应该是动态规划，如官方题解，设f(x)为打劫前x家房子所能得到的最大的资金，很容易想到动态规划的边界条件，即：

f(1)=nums[1]

f(2)=max(nums[1],nums[2])

然后是最关键的动态转移方程，如果要打劫第n家，就必然不能打劫第n-1家，所以打劫第n家得到的钱一共是第n家的钱加上前n-2家获得的最多的钱，即：f(n-2)+nums(n)，如果不打劫第n家，获得的最大收益就是f(n-1)，两者我们要去较大的那个，所以动态转移方程是：

f(n)=max(nums[n]+f(n-2),f(n-1))

到这里，这道题就能顺利通过了
    * */
    public int rob(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        if (nums.length==1){
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[dp.length-1];
    }
}
