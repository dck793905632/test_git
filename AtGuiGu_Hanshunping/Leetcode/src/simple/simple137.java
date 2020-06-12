package simple;

import java.util.Arrays;

public class simple137 {
    public static void main(String[] args) {
        int[] nums ={2,2,3,2};
        System.out.println(singleNumber(nums));
    }
    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);

        for (int i=0;i<nums.length;i+=3){
            if (i==nums.length-1 || nums[i]!=nums[i+2]){
                return nums[i];
            }
        }
        return -1;
    }
    /*public static int singleNumber(int[] nums) {
        int j,i;
        for ( i = 0; i < nums.length; i++) {
            for ( j = 0; j < nums.length; j++) {
                if (i!=j){
                    if (nums[i]==nums[j]){
                        break;
                    }
                }
            }
            if (j==nums.length){
                return nums[i];
            }
        }
        return -1;
    }*/
}
