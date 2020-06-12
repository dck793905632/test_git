package binarySearch;

import org.junit.Test;

public class medium34 {
    @Test
    public void test(){
        int[] nums = new int[]{1,1,8,8,8,8,10};
        System.out.println(findLeft(nums,8));
        System.out.println(findRight(nums,8));
    }
    private int findLeft(int[] nums, int target){
        int len = nums.length;
        int res = -1;
        int start = 0;
        int end = len - 1;
        while (start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] < target){
                start = mid + 1;
            }
            else {
                if(nums[mid] == target){
                    res = mid;
                }
                end = mid - 1;
            }
        }

        return res;

    }

    private int findRight(int[] nums, int target){
        int len = nums.length;
        int res = -1;
        int start = 0;
        int end = len - 1;
        while (start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] > target){
                end = mid - 1;
            }
            else {
                if(nums[mid] == target){
                    res = mid;
                }
                start = mid + 1;

            }
        }

        return res;

    }
}
