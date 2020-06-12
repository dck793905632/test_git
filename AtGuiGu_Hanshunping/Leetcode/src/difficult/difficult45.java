package difficult;

import org.junit.Test;

public class difficult45 {
    @Test
    public void test(){
        int[] nums = new int[]{2,3,1,1,4};
        System.out.println(jump(nums));
    }
    public int jump(int[] nums) {
        int length = nums.length-1;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

}
