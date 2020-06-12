package simple;

import java.util.Arrays;

public class simple283 {
    public static void main(String[] args) {
        int[] nums={0,1,0,3,12};
        moveZeroes(nums);
    }
    public static void moveZeroes(int[] nums) {
        int i=0;
        int j=0;
        int temp=0;
        while (j<nums.length){
            if (nums[j]==0){
                j++;
            }else {
                temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;
                j++;
            }
        }
    }
}
