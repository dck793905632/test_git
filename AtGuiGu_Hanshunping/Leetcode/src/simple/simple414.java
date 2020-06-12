package simple;

public class simple414 {
    public static void main(String[] args) {
        int[] nums = {3,2,1};
        System.out.println(thirdMax(nums));
    }
    public static int thirdMax(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        if (nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        int max1=Integer.MIN_VALUE;
        int max2=Integer.MIN_VALUE;
        int max3=Integer.MIN_VALUE;

        int f=0;
        boolean flag =true;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==Integer.MIN_VALUE &&flag){
                f++;
                flag=false;
            }
            if (nums[i]>max1){
                f++;
                max3=max2;
                max2=max1;
                max1=nums[i];
            }else if (nums[i]>max2 && nums[i]<max1){
                f++;
                max3=max2;
                max2=nums[i];
            }else if (nums[i]>max3 && nums[i]<max2){
                f++;
                max3=nums[i];
            }
        }
        return f>=3?max3:max1;
    }
}
