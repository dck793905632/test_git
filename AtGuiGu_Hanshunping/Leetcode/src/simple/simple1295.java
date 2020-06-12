package simple;

public class simple1295 {
    public static void main(String[] args) {

    }
    public int findNumbers(int[] nums) {
        int count =0;
        for (int i = 0; i < nums.length; i++) {
            if (String.valueOf(nums[i]).length()%2==0){
                count++;
            }
        }
        return count;
    }
}
