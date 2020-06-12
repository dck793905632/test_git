package simple;

import java.util.Arrays;

public class simple561 {
    public static void main(String[] args) {

    }
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int min=0;
        for (int i=0;i<nums.length;i+=2){
            min=min+Math.min(nums[i],nums[i+1]);
        }
        return min;
    }
}
