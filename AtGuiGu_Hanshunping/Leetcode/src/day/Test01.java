package day;

import org.junit.Test;

import java.util.Arrays;

public class Test01 {
    //将一个数组分成奇数部分和偶数部分，并分别排好序
    @Test
    public void test(){
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9,9};
        int index = help(nums);
        System.out.println(Arrays.toString(nums));
        quickSort(nums,0,index-1);
        quickSort(nums,index,nums.length-1);
        System.out.println(Arrays.toString(nums));

    }
    public int help(int[] nums){
        int i=0;
        int j = nums.length-1;
        while (i<j){
            while (i<j && nums[i]%2==1){
                i++;
            }
            while (i<j && nums[j]%2==0){
                j--;
            }
            int temp = nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
        return i;
    }
    public void quickSort(int[] nums,int left,int right){
        //如果左索引比右索引大，直接返回
        if (left>right){
            return;
        }
        int i=left;
        int j=right;
        int base = nums[left];
        while(i!=j){
            //从右边开始找，找比base小的数，i<j防止越界
            while (nums[j]>=base && i<j){
                j--;
            }
            //从左边开始找，找比base大的数.i<j防止越界
            while (nums[i]<=base && i<j){
                i++;
            }
            int temp = nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
        nums[left]=nums[i];
        nums[i]=base;
        quickSort(nums,left,i-1);
        quickSort(nums,j+1,right);
    }
}
