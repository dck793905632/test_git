package huadongchuangkou;

import org.junit.Test;

import java.util.Arrays;

public class MoveZeros {
    @Test
    public void test(){
        /*int[] nums = new int[]{0,1,2,3,4,0,30,0,0,0,12,3,3,3};
        moveZero(nums);*/
        String str = " a sd sd as  s  asd a dsas   asd a  s  ";
        System.out.println(str.trim());
    }
    public void moveZero(int[] nums){
        int i=0;
        for (int j = 0; j < nums.length; j++) {
            if(nums[j]!=0){
                nums[i]=nums[j];
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));

    }
}
