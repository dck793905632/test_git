package simple;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class simple349 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{4,9,5};
        int[] nums2 = new int[]{9,4,9,8,4};
        int[] intersection = intersection(nums1, nums2);
        System.out.println(Arrays.toString(intersection));
    }

    static Set<Integer> set = new HashSet<>();
    public static int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        for (int i=0;i<nums2.length;i++){
            binarySearch(nums1,nums2[i]);
        }
        int[] newArr = new int[set.size()];
        int index=0;
        for (int n : set){
            newArr[index]=n;
            index++;
        }
        return newArr;
    }
    public static void binarySearch(int[] nums1,int target){

        int left =0;
        int right =nums1.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            if (nums1[mid]==target){
                set.add(nums1[mid]);
                break;
            }else if (nums1[mid]<target){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
    }
}
