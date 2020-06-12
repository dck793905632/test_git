package simple;

import java.util.HashSet;
import java.util.Set;

public class simple217 {
    public static void main(String[] args) {
        int[] arr = {1};
        System.out.println(containsDuplicate(arr));
    }
    public static boolean containsDuplicate(int[] nums) {
        if (nums.length==1){
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        System.out.println(set.size());
        return set.size()!= nums.length;
    }
    /*public static boolean containsDuplicate(int[] nums) {

        for (int i =0;i<nums.length-1;i++){
            for (int j=i+1;j<nums.length;j++)
            if (nums[i]==nums[j]){
                return true;
            }
        }
        return false;
    }*/
}
