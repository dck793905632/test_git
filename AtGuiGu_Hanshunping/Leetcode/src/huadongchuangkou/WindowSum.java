package huadongchuangkou;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class WindowSum {
    @Test
    public void test(){
        int[] nums= new int[]{1,2,7,8,5};
        System.out.println(minSum(nums,3));
    }
    public List<Integer> minSum(int[] nums,int k){
        int i=0;
        int j;
        int sum=0;
        for(int l=i;l<k;l++) {
            sum += nums[l];
        }
        List<Integer> list = new ArrayList<>();
        list.add(sum);
        for (j=k;j<nums.length;j++){
            sum-=nums[i];
            sum+=nums[j];
            i++;
            list.add(sum);

        }
        return list;
    }
}
