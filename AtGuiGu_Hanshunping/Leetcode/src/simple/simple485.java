package simple;

public class simple485 {
    public static void main(String[] args) {

    }
    public int findMaxConsecutiveOnes(int[] nums) {
        int temp =0;
        int count =0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0){
                count++;
            }else {
                count=0;
            }
            temp=Math.max(temp,count);

        }
        return temp;
    }
}
