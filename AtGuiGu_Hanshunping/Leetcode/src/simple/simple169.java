package simple;

import java.util.HashMap;
import java.util.Map;

public class simple169 {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            map.putIfAbsent(nums[i],0);
            map.put(nums[i],map.get(nums[i])+1);
        }
        for(int key : map.keySet()){
            if(map.get(key)>n/2){
                return key;
            }
        }
        return -1;
    }
}
