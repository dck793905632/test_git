package huadongchuangkou;

import org.junit.Test;

public class medium567 {
    @Test
    public void test(){
        String  s1 = "adc" , s2 = "dcda";
        System.out.println(checkInclusion(s1,s2));
    }
    public boolean checkInclusion(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int len1 = c1.length;
        int len2 = c2.length;
        if(len1>len2){
            return false;
        }
        int[] c1Char = new int[26];
        int[] c2Char = new int[26];
        for(int i=0;i<len1;i++){
            c1Char[c1[i]-'a']++;
            c2Char[c2[i]-'a']++;
        }
        for(int i=len1;i<len2;i++){
            if(compare(c1Char,c2Char)){
                return true;
            }else{
                c2Char[c2[i-len1]-'a']--;
                c2Char[c2[i]-'a']++;
            }
        }
        return compare(c1Char,c2Char);
    }
    public boolean compare(int[] c1Char,int[] c2Char){
        for(int i=0;i<26;i++){
            if(c1Char[i]!=c2Char[i]){
                return false;
            }
        }
        return true;
    }
}
