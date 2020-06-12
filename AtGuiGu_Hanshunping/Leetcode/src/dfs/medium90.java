package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class medium90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
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
            if(i!=startIndex && nums[i]==nums[i-1]){
                continue;
            }
            list.add(nums[i]);
            dfs(nums,i+1,list,results);
            list.remove(list.size()-1);
        }

    }
}
