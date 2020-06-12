package medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class medium152 {
    @Test
    public void test(){
        int[][] nums = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        Arrays.sort(nums, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                System.out.print(nums[i][j]+" ");
            }
            System.out.println();
        }


    }
    public int maxProduct(int[] nums) {
        int max=Integer.MIN_VALUE,imax=1,imin=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                int temp = imax;
                imax=imin;
                imin=temp;
            }
            imax=Math.max(imax*nums[i],nums[i]);
            System.out.println("imax"+imax);
            imin=Math.min(imin*nums[i],nums[i]);
            System.out.println("imin"+imin);
            max=Math.max(max,imax);
        }
        return Math.max(max,imax);

    }
}
