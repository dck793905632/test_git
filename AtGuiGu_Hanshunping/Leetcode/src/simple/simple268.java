package simple;

import java.util.Arrays;

public class simple268 {
    public static void main(String[] args) {
        int[] nums = {0,1};
        int i = missingNumber(nums);
        System.out.println(i);
    }
    public static int missingNumber(int[] nums) {
        int len =nums.length;
        int i,j;
        for ( i = 0; i <len; i++) {
            for (j = 0; j < len; j++) {
                if (i==nums[j]){
                    break;
                }
            }
            if (j==len){
                return i;
            }
        }
        return nums.length;
    }
    /*public static int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=i){
                return i;
            }
        }
        return nums.length;
    }*/
}
