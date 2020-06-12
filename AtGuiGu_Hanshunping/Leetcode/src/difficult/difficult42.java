package difficult;

import org.junit.Test;

import java.util.Arrays;

public class difficult42 {
    @Test
    public void test(){
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
    public int trap(int[] height) {
        int length = height.length;
        int[] left = new int[length];//保存从左往右遍历时，每一个下标位置当前的最高柱子高度
        int[] right = new int[length];//保存从右往左遍历时，每一个下标位置当前的最高柱子高度
        int leftMax = 0;
        int rightMax = 0;
        int sum = 0;

        //计算left和right数组
        for (int i = 0; i < length; i++) {
            if (height[i] > leftMax) {
                leftMax = height[i];
            }
            left[i] = leftMax;
            if (height[length-1-i] > rightMax) {
                rightMax = height[length-1-i];
            }
            right[length-1-i] = rightMax;
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));

        //遍历，只有当前柱子往左看、往右看的最高柱子都比当前柱子高，才能接住雨水
        for (int j = 0; j < length; j++) {
            if (height[j] < left[j] && height[j] < right[j]) {
                sum = sum + Math.min(left[j], right[j]) - height[j];
            }
        }
        return sum;
    }

}
