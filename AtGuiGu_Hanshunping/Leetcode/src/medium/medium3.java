package medium;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class medium3 {
    @Test
    public void test(){
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        Set<Character> set = new HashSet<>();
        int ans=0,i=0,j=0;
        while(i<n && j<n){
            if(!set.contains(chars[j])){
                set.add(chars[j]);
                j++;
                ans=Math.max(ans,j-i);

            }else{
                set.remove(chars[i]);
                i++;
            }
        }
        return ans;
    }
}
