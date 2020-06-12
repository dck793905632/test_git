package simple;

import java.lang.reflect.Array;
import java.util.*;

public class simple532 {
    public static void main(String[] args) {
        int[] nums={3, 1, 4, 1, 5};
        System.out.println(findPairs(nums,2));
    }
    public static int findPairs(int[] nums, int k) {
        if(k<0){
            return 0;
        }
        Map<Integer,Integer> map = new HashMap<>();
        int count=0;
        for (int i=0;i<nums.length;i++){
            map.putIfAbsent(nums[i],0);
            map.put(nums[i],map.get(nums[i])+1);
        }
        for (Integer key : map.keySet()) {
            if (k==0){
                if (map.get(key)>1){
                    count++;
                }
            }else {
                if (map.containsKey(k+key)){
                    count++;
                }
            }
        }
        return count;
    }
}
