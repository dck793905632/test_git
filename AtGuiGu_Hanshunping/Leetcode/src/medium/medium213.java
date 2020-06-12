package medium;

import org.junit.Test;

import javax.swing.plaf.metal.MetalTheme;

public class medium213 {
    @Test
    public void test(){
        int[] nums = new int[]{2,3,2};
        System.out.println(rob(nums));
    }
    public int rob(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        if (nums.length==0){
            return 0;
        }
        int[] a = new int[nums.length];
        int[] b = new int[nums.length];
        //a为偷第一间
        a[0]=nums[0];
        a[1]=nums[0];
        //b不偷第一间
        b[0]=0;
        b[1]=nums[1];
        for (int i = 2; i < nums.length; i++) {
            a[i]=Math.max(a[i-2]+nums[i],a[i-1]);
            b[i]=Math.max(b[i-2]+nums[i],b[i-1]);
        }
        return Math.max(b[b.length-1],a[a.length-2]);
    }
    /*public int rob(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        if (nums.length==0){
            return 0;
        }
        int dp1[] = new int[nums.length];
        dp1[0]=nums[0];
        dp1[1]=Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp1[i]= Math.max(nums[i]+dp1[i-2],dp1[i-1]);
        }
        int dp2[] = new int[nums.length];
        dp2[dp2.length-1]=nums[nums.length-1];
        dp2[dp2.length-2]=Math.max(nums[nums.length-2],nums[nums.length-1]);
        for (int i = dp2.length-3; i >0 ; i--) {
            dp2[i]=Math.max(nums[i]+dp2[i+2],dp2[i+1]);
        }
        return Math.max(dp1[dp1.length-1],dp2[1]);
    }*/
}
