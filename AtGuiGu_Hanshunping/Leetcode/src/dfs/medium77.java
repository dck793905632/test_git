package dfs;

import java.util.ArrayList;
import java.util.List;

public class medium77 {
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i]=i+1;
        }
        boolean[] visited = new boolean[n];
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums,k,0,visited,list,res);
        return res;
    }
    public void dfs(int[] nums,
                    int k,
                    int start,
                    boolean[] visited,
                    List<Integer> list,
                    List<List<Integer>> res){
        if(list.size()==k){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=start;i<nums.length;i++){
            if(visited[i]){
                continue;
            }
            list.add(nums[i]);
            visited[i]=true;
            dfs(nums,k,i+1,visited,list,res);
            visited[i]=false;
            list.remove(list.size()-1);
        }

    }
}
