package medium;

import org.junit.Test;

public class medium151 {
    @Test
    public void test(){
        String s = "a good   example";
        System.out.println(reverseWords(s));
    }
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=strs.length-1;i>=0;i--){
            if(!strs[i].equals("")){
                sb.append(strs[i]+" ");
            }
        }
        return sb.toString().trim();
    }
}
