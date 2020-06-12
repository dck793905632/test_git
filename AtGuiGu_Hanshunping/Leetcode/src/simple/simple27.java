package simple;

public class simple27 {
    public static void main(String[] args) {
        int[] arr = {0,1,2,2,3,0,4,2};
        int i = removeElement(arr, 2);
        System.out.println(i);
    }
    /*public static int removeElement(int[] nums, int val) {
        int i=0;
        for (int j=0;j<nums.length;j++){
            if (nums[j]!=val){
                nums[i]=nums[j];
                i++;
            }
        }

        return i;
    }*/
    public static int removeElement(int[] nums, int val) {
        int i=0;
        int j=0;
        while (j<nums.length){
            if (nums[j]==val){
                j++;
            }else {
                nums[i]=nums[j];
                i++;
                j++;
            }
        }
        for (int k = 0; k < nums.length; k++) {
            System.out.println(nums[k]);
        }
        return i;
    }
}
