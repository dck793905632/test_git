package dfs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class medium47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] vistied = new boolean[nums.length];
        if(nums.length==0){
            return results;
        }
        Arrays.sort(nums);

        dfs(nums,vistied,list,results);
        return results;
    }
    public void dfs(int[] nums,
                    boolean[] vistied,
                    List<Integer> list,
                    List<List<Integer>> results){
        //递归出口
        if(list.size()==nums.length){
            results.add(new ArrayList<>(list));
            return;
        }
        //递归拆解
        for(int i=0;i<nums.length;i++){
            if(vistied[i]){
                continue;
            }
            if(i!=0 && nums[i]==nums[i-1] && !vistied[i-1]){
                continue;
            }
            list.add(nums[i]);
            vistied[i]=true;
            dfs(nums,vistied,list,results);
            vistied[i]=false;
            list.remove(list.size()-1);
        }

    }
}
