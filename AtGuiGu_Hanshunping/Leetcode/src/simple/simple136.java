package simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class simple136 {
    public static void main(String[] args) {
        int[] nums ={4,1,2,1,2};
        System.out.println(singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
            }
        }
        return ans;
    }


    /*public static int singleNumber(int[] nums) {

        int cur;
        int j,i;
        for ( i = 0; i < nums.length; i++) {
            for ( j = 0; j < nums.length; j++) {
                if (i!=j){
                    if (nums[i]==nums[j]){
                        break;
                    }
                }
            }
            if (j==nums.length){
                return nums[i];
            }
        }
        return -1;
    }*/
    /*public int singleNumber(int[] nums) {

        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            map.putIfAbsent(nums[i],0);
            map.put(nums[i],map.get(nums[i])+1);
        }
        for (Integer key:map.keySet()){
            if (map.get(key)==1){
                return key;
            }
        }
        return -1;
    }*/
}
