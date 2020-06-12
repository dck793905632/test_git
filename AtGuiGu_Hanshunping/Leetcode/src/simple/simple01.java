package simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class simple01 {
    public static void main(String[] args) {
        int[] nums ={2, 7, 11, 15};
        int[] ints = twoSum(nums, 9);
        System.out.println(Arrays.toString(ints));

    }
   /* public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]+nums[j]==target){
                    res[0]=i;
                    res[1]=j;
                }
            }
        }
        return res;
    }*/

    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }

        for (int i =0 ;i <map.size();i++){
            int com = target-nums[i];
            if(map.containsKey(com)&&map.get(com)!=i){
                return new int[]{i,map.get(com)};
            }
        }
        return null;
    }
}
