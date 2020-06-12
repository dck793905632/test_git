package simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class simple350 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{4,9,5,9};
        int[] nums2 = new int[]{9,4,9,8,4};
        int[] intersection = intersect(nums1, nums2);
        System.out.println(Arrays.toString(intersection));
    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map1.putIfAbsent(nums1[i],0);
            map1.put(nums1[i],map1.get(nums1[i])+1);
        }

        for (int i = 0; i < nums2.length; i++) {
            map2.putIfAbsent(nums2[i],0);
            map2.put(nums2[i],map2.get(nums2[i])+1);
        }

        int index=0;
        for (Integer key:map1.keySet()){
            if (map2.containsKey(key)){
                int min = Math.min(map1.get(key),map2.get(key));
                for (int j=0;j<min;j++){
                    nums1[index]=key;
                    index++;
                }
            }
        }
        return Arrays.copyOfRange(nums1,0,index);
    }
}
