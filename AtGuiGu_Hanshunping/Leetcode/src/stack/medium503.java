package stack;

import java.util.Stack;

public class medium503 {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            res[i]=-1;
        }
        for(int i=0;i<nums.length*2;i++){
            int index = i % nums.length;
            while(!stack.isEmpty() && nums[index]>nums[stack.peek()]){
                res[stack.pop()]=nums[index];
            }
            stack.push(index);
        }

        return res;
    }
}
