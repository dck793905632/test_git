package simple;

import org.junit.Test;

public class StringZIp {
    @Test
    public void test(){
        String S = "aabcccccaaa";
        System.out.println(compressString(S));
    }
    public String compressString(String S) {
        int i=0;
        int j=0;
        char[] chars = S.toCharArray();
        int len =chars.length;
        StringBuilder sb = new StringBuilder();
        while(i<len){
            int sum=0;
            sb.append(chars[i]);
            while (j<len){
                if(chars[i]==chars[j]){
                    sum++;
                    j++;
                }else{
                    break;
                }
            }
            sb.append(sum);
            i=j;
        }
        return sb.toString().length()>=S.length()? S : sb.toString();
    }
}
