package dfs;

import java.util.ArrayList;
import java.util.List;

public class medium131 {
    public List<List<String>> partition(String s) {
        //切割字符串问题，n个字符串，中间是n-1个数字
        List<List<String>> results = new ArrayList<>();
        if(s.length()==0){
            return results;
        }
        List<String> combination = new ArrayList<>();
        dfs(s,0,combination,results);
        return results;
    }

    public void dfs(String s,
                    int startIndex,
                    List<String> combination,
                    List<List<String>> results){
        //递归出口
        if(s.length()==startIndex){
            results.add(new ArrayList<String>(combination));
            return;
        }
        //拆解递归
        for(int i=startIndex;i<s.length();i++){
            String substr =s.substring(startIndex,i+1);
            if(!isP(substr)){
                continue;
            }
            combination.add(substr);
            dfs(s,i+1,combination,results);
            combination.remove(combination.size()-1);
        }
    }

    public boolean isP(String s){
        char[] chars = s.toCharArray();
        int j = chars.length-1;
        for(int i=0;i<chars.length/2;i++){
            if(chars[i]!=chars[j]){
                return false;
            }
            j--;
        }
        return true;
    }
}
