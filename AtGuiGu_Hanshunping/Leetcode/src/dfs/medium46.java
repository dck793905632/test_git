package dfs;

import org.junit.Test;

import java.util.*;

public class medium46 {
    @Test
    public void test(){
        /*boolean[] visted = new boolean[5];
        System.out.println(Arrays.toString(visted));*/
        int[] nums = new int[]{1,2,3};
        System.out.println(permute(nums));
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums,visited,list,results);
        return results;

    }

    public void dfs(int[] nums,
                    boolean[] visited,
                    List<Integer> list,
                    List<List<Integer>> results){
        //递归出口
        if(list.size()==nums.length){
            results.add(new ArrayList<>(list));
            return;
        }
        //递归拆解
        for(int i=0;i<nums.length;i++){
            if(visited[i]){
                continue;
            }
            list.add(nums[i]);
            visited[i]=true;
            dfs(nums,visited,list,results);
            visited[i]=false;
            list.remove(list.size()-1);
        }
    }
    /*public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        dfs(nums,set,list,results);
        return results;

    }

    public void dfs(int[] nums,
                    Set<Integer> set,
                    List<Integer> list,
                    List<List<Integer>> results){
        //递归出口
        if(list.size()==nums.length){
            results.add(new ArrayList<>(list));
            return;
        }
        //递归拆解
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            set.add(nums[i]);
            dfs(nums,set,list,results);
            set.remove(nums[i]);
            list.remove(list.size()-1);
        }
    }*/
}
