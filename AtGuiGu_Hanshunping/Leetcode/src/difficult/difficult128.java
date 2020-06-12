package difficult;

import org.junit.Test;

import java.util.HashSet;

public class difficult128 {
    @Test
    public void test(){
        int[] nums = new int[]{100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num :nums){
            set.add(num);
        }
        int max=0;
        for(int i=0;i<set.size();i++){
            if(!set.contains(nums[i]-1)){
                int curNum = nums[i];
                int curLen=1;
                while (set.contains(curNum+1)){
                    curLen++;
                    curNum++;
                }
                max=Math.max(max,curLen);
            }
        }
        return max;
    }
}
