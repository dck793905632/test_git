package dfs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class medium15 {
    @Test
    public void test(){
        System.out.println(letterCombinations("23"));
    }
    static String[] map =
            {"","", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> results = new ArrayList<>();
        String str="";
        dfs(digits,str,0,results);
        return results;

    }

    public void  dfs(String digits,
                     String str,
                     int index,
                     List<String> results){
        //递归出口
        if (index>=digits.length()){
            results.add(str);
            return;
        }
        int mapIndex = digits.charAt(index) - '0';
        for(int i=0;i<map[mapIndex].length();i++){
            dfs(digits,str+map[mapIndex].charAt(i),index+1,results);
        }
    }
}
