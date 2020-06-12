package dfs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class medium40 {
    @Test
    public void test(){
        int[] candidates = new int[]{10,1,2,7,6,1,1,5};
        System.out.println(combinationSum2(candidates,8));

    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if(candidates.length==0){
            return results;
        }
        Arrays.sort(candidates);
        List<Integer> combination = new ArrayList<>();
        dfs(candidates,0,target,combination,results);
        return results;

    }
    //1 递归定义
    //找到所有combination组合和为target,扔到results,下一个可以加入combination的数从startindex开始
    public void dfs(int[] candidates,
                    int startIndex,
                    int remainTarget,
                    List<Integer> combination,
                    List<List<Integer>> results){
        //递归出口
        if(remainTarget==0){
            results.add(new ArrayList(combination));
            return;
        }
        //递归拆解
        for(int i=startIndex;i<candidates.length;i++){
            if(remainTarget<candidates[i]){
                break;
            }
            if(i!=startIndex && candidates[i]-candidates[i-1]==0){
                continue;
            }
            combination.add(candidates[i]);
            dfs(candidates,i+1,remainTarget-candidates[i],combination,results);
            combination.remove(combination.size()-1);
        }

    }
}
