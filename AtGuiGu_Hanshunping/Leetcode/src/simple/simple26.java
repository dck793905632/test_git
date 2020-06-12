package simple;

public class simple26 {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int i = removeDuplicates(nums);
        System.out.println(i);
    }
    public static int removeDuplicates(int[] nums) {
        int i=0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i]!=nums[j]){
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;
    }
    /*public static int removeDuplicates(int[] nums) {
        //双指针
        int i=0;
        int j =1;
        while (j<nums.length){
            if (nums[i]==nums[j]){
                j++;
            }else {
                i++;
                nums[i]=nums[j];
                j++;
            }
        }

        return i+1;
    }*/
}
