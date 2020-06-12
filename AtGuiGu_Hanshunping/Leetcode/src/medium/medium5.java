package medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class medium5 {

    @Test
    public void test(){
        String s = "babad";

        List<String> list = new ArrayList<>();
        dfs(s,0,list);
        String str1="";
        int len=Integer.MIN_VALUE;
        for(int i=0;i<list.size();i++){
            if(len<list.get(i).length()){
                str1=list.get(i);
                len=list.get(i).length();
            }
        }
    }

    public void dfs(String s,
                    int startIndex,
                    List<String> list){
        for(int i=startIndex;i<s.length();i++){
            String str1 = s.substring(startIndex, i + 1);
            if (isP(str1)){
                list.add(str1);
            }
            dfs(s,i+1,list);

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
