package jd;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }


    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] vistied = new boolean[nums.length];
        dfs(nums,res,list,vistied);
        return res;
    }
    public static void dfs(int[] nums,
                    List<List<Integer>> res,
                    List<Integer> list,
                    boolean[] vistied){
        if(list.size()!=0){
            res.add(new ArrayList<>(list));
            // return;
        }
        for(int i=0;i<nums.length;i++){
            if(vistied[i]==true){
                continue;
            }
            list.add(nums[i]);
            vistied[i]=true;
            dfs(nums,res,list,vistied);
            vistied[i]=false;
            list.remove(list.size()-1);
        }

    }
}
