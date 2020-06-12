package simple;

import java.lang.reflect.Array;
import java.util.Arrays;

public class simple189 {
    public static void main(String[] args) {
        int[] arr = {-1,-100,3,99};
        rotate(arr,2);
    }
    public static void rotate(int[] nums, int k) {

        int temp =0;
        for (int i=0;i<k;i++){
            temp=nums[nums.length-1];
            for (int j=nums.length-1;j>=0;j--){
                if (j==0){
                    nums[j]=temp;
                }else {
                    nums[j]=nums[j-1];
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
