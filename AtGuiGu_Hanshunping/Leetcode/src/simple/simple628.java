package simple;

import java.util.Arrays;

public class simple628 {
    public static void main(String[] args) {
        System.out.println(maximumProduct(new int[]{-5,-6,1,2,3,4}));
    }
    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3],
                nums[nums.length-1]*nums[0]*nums[1]);
    }
    /*public static int maximumProduct(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    max=Math.max(max,nums[i]*nums[j]*nums[k]);
                }
            }
        }
        return max;
    }*/
}
