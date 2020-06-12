package top100;

import org.junit.Test;

public class medium287 {
    @Test
    public void test(){
        int[] nums = new int[]{3,1,3,4,2};
        System.out.println(findDuplicate(nums));
    }
    public int findDuplicate(int[] nums) {
        int left = 1;
        int right=nums.length-1;
        while(left<right){
            int mid = (left+right+1)/2;
            int cnt=0;
            for(int num : nums){
                if(num<mid){
                    cnt++;
                }
            }
            if(cnt>=mid){
                right=mid-1;
            }else{
                left=mid;
            }

        }
        return left;

    }
}
