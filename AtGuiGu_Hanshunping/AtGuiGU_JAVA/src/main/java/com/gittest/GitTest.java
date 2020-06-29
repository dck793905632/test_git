package com.gittest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class GitTest {
    public static void main(String[] args) {
        System.out.println("git Test");
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
    }
    @Test
    public void  test(){
        int[] nums = new int[]{-10,-2,-1,0,0,0,0,0,0,2,3,4};
        System.out.println(diffSquareNum(nums));
    }
    @Test
    public void test01(){
        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(2);
        queue.offer(1);
        queue.offer(4);
        queue.offer(3);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        List<Integer> list = new ArrayList<>();
    }


    public int[] finMin(int[] s,int c){
        int i=0;
        int j=0;
        int left=0;
        int right=0;
        int min=Integer.MAX_VALUE;
        int n=s.length;
        int sum=0;
        while(j<=n){
            if(sum<=c){
                sum+=s[j];
                j++;
                min=Math.min(min,c-sum);
                if(min==c-sum){
                    left=i;
                    right=j;
                }
            }else {
                sum-=s[i];
                i++;
            }
        }
        int[] res = new int[right-left];
        for (int k = left; k < right; k++) {
            res[k-left]=s[k];
        }
        return res;
    }


    public int[][] findContinuousSequence(int target){
        int i=1;
        int j=1;
        int sum=0;
        List<int[]> list = new ArrayList<>();
        while(i<target/2){
            if (sum<target){
                sum+=j;
                j++;
            }else if(sum>target){
                sum-=i;
                i++;
            }else {
                int[] arr = new int[j+1-i];
                for(int k=i;k<j;k++){
                    arr[k-i]=i;
                }
                list.add(arr);
                sum-=i;
                i++;
            }

        }
        return list.toArray(new int[list.size()][]);
    }

    public int diffSquareNum(int nums[]) {
        int n = nums.length;
        if(n == 0 || nums == null){
            return 0;
        }
        int sum = 0;
        int left = 0;
        int right = n - 1;
        while(left <= right){
            if(nums[left] + nums[right] == 0){
                sum++;
                int temp = nums[left];
                //这里开始去掉后面重复的数字
                while(left <= right && nums[left] == temp)
                    left++;
                while(left <= right && nums[right] == -temp)
                    right--;
            }
            else if(nums[left] + nums[right] < 0){
                sum++;
                int temp = nums[left];
                while(left <= right && nums[left] == temp)
                    left++;
            }
            else {
                sum++;
                int temp = nums[right];
                while(left <= right && nums[right] == temp)
                    right--;
            }
        }
        return sum;
    }

    public ArrayList findPair(int[] nums, int k){
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        ArrayList<Integer> list = new ArrayList<>();
        while(i < j){
            if(nums[i] + nums[j] < k){
                i++;
            }else if(nums[i] + nums[j] > k){
                j--;
            }else{
                list.add(nums[i]);
                list.add(nums[j]);
                j--;
            }
        }
        return list;
    }
}
