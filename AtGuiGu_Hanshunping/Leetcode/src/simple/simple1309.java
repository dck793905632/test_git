package simple;

import java.util.Arrays;

public class simple1309 {
    public static void main(String[] args) {
        System.out.println(freqAlphabets("10#11#12"));
    }
    public static String freqAlphabets(String s) {
        char[] m = new char[26];
        int j=0;
        for (char i='a';i<='z';i++){
            m[j]=i;
            j++;
        }
        String str ="";
        for(int i=s.length()-1;i>=0;i--){
            int cur=0;
            if (s.charAt(i)=='#'){
                cur= (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
                str=m[cur-1]+str;
                i-=2;
            }else {
                cur=s.charAt(i)-'0';
                str=m[cur-1]+str;
            }
        }
        return str;
    }
}
