package dfs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class medium78 {

    @Test
    public void  test(){
        int[] nums = new int[]{1,2,3};
        System.out.println(subsets(nums));
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums,0,list,results);
        return results;
    }
    public void dfs(int[] nums,
                    int startIndex,
                    List<Integer> list,
                    List<List<Integer>> results){
        results.add(new ArrayList<Integer>(list));
        for(int i=startIndex;i<nums.length;i++){
            list.add(nums[i]);
            dfs(nums,i+1,list,results);
            list.remove(list.size()-1);
        }

    }
}
