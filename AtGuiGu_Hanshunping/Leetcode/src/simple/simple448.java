package simple;

import java.util.ArrayList;
import java.util.List;

public class simple448 {
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};
        List<Integer> disappearedNumbers = findDisappearedNumbers(arr);
        System.out.println(disappearedNumbers);
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        //【笔记】将所有正数作为数组下标，置对应数组值为负值。那么，仍为正数的位置即为（未出现过）消失的数字。
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            nums[Math.abs(nums[i])-1]=-Math.abs(nums[Math.abs(nums[i])-1]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0){
                list.add(i+1);
            }
        }
        return list;
    }
    /*public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();

        int i = 0;
        int j = 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                i++;
                nums[i] = nums[j];
                j++;
            }
        }
        int l;
        int k;
        for (l = 1; l <= nums.length; l++) {
            for (k = 0; k < i + 1; k++) {
                if (nums[k] == l) {
                    break;
                }
            }
            if (k==i+1) {
                list.add(l);
            }
        }
        return list;
    }*/
}
