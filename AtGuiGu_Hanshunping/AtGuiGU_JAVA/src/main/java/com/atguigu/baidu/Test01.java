package com.atguigu.baidu;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

public class Test01 {
    @Test
    public void test(){
        int[] nums = new int[]{1,2,3};
        int x=9999;
        int c=0;
        while (x>0){
            c++;
            x=x&(x-1);
        }
        System.out.println(c);
    }

    public void teeee(int[] nums){
        Stack<Integer> stack =new Stack<>();
        stack.push(nums.length-1);
        int count=0;
        int j=nums.length-2;
        while (!stack.isEmpty()){
            for(;j>=0;j--){
                if (nums[j]>=stack.peek()){
                    stack.pop();
                    stack.push(nums[j]);
                }else {
                    stack.push(nums[j]);
                }
            }
            int len=stack.size();
            if (len==1 || len==0){
                break;
            }
            for(int i=0;i<len;i++){
                nums[i]=stack.pop();
            }

            j=len-1;
            stack.push(nums[j]);

            count++;

        }
        System.out.println(count);

    }
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]==target){
                if(nums[mid]==nums[mid-1]){
                    while (nums[mid]==nums[mid-1]){
                        mid-=1;
                    }
                }
                return mid;
            }else if (nums[mid]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return -1;
    }
    public void LenWord(String str){
        char[] cs = str.toCharArray();
        int index=0;
        int len=0;
        int l=1;
        for(int i=1;i<cs.length;i++){
            if(cs[i]==cs[i-1]){
                l++;
            }else {
                l=1;
            }
            len=Math.max(len,l);
            index=i;

        }
        String res =str.substring(index-len+1,index+1);
        System.out.println(res);
        System.out.println(index+" "+len);

    }
    public void Lword(String str){
        char[] cs = str.toCharArray();
        int[] dp = new int[cs.length];
        dp[0]=1;
        for(int i=1;i<cs.length;i++){
            if(cs[i]==cs[i-1]){
                dp[i]=dp[i-1]+1;
            }else {
                dp[i]=1;
            }
        }
        System.out.println(Arrays.toString(dp));

    }


    public void sort(int[] nums,int len){
        int i=0;
        int j=len-1;
        int k=0;
        while (nums[i]==0){
            i++;
        }
        k=i+1;
        while (nums[j]==2){
            j--;
        }
        while(k<=j){
            if(nums[k]==1){
                k++;
            }else if(nums[k]==0){
                int tmp = nums[i];
                nums[i]=nums[k];
                nums[k]=tmp;
                while (nums[i]==0){
                    i++;
                }
            }else if(nums[k]==2){
                int tmp = nums[j];
                nums[j]=nums[k];
                nums[k]=tmp;
                while (nums[j]==2){
                    j--;
                }
            }
        }

    }

    public int[] helper(int[] nums){
        int n = nums.length;
        if (n==0){
            return null;
        }
        for(int i =0;i<n/2;i++){
            int tmp = nums[i];
            nums[i]=nums[n-1-i];
            nums[n-1-i]=tmp;
        }
        return nums;

    }
}
