package dicttree;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class medium820 {

    @Test
    public void test(){
        String[] words = new String[]{"time", "me", "bell"};
        System.out.println(minimumLengthEncoding(words));
    }
    public int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet<>();
        for(String word:words){
            set.add(word);
        }
        for(String word:words){
            for(int i=1;i<word.length();i++){
                set.remove(word.substring(i));
            }
        }
        int res=0;
        for(String word : set){
            res+=word.length()+1;
        }
        return res;
    }
}
