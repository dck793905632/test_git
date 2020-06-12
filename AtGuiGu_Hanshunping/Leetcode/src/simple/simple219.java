package simple;

public class simple219 {
    public static void main(String[] args) {
        int[] nums={1,2,3,1,2,3};
        System.out.println(containsNearbyDuplicate(nums,2));
    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        int i;
        int j;
        for (i=0;i<nums.length-1;i++){
            for (j=i+1;j<nums.length;j++){
                if (nums[i]==nums[j]&&Math.abs(i-j)<=k){
                    return true;
                }
            }
        }
        return false;
    }
}
