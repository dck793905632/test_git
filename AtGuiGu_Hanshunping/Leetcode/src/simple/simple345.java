package simple;

import java.util.Arrays;

public class simple345 {
    public static void main(String[] args) {
        String s = "ai";
        String s1 = reverseVowels(s);
        System.out.println(s1);
    }
    public static String reverseVowels(String s) {

        char temp;
        char[] chars = s.toCharArray();
        int i=0;
        int j=chars.length-1;
        while (i<j){
            if (isVowel(chars[i])){
                if (isVowel(chars[j])){
                    temp=chars[i];
                    chars[i]=chars[j];
                    chars[j]=temp;
                    i++;
                    j--;
                }else {
                    j--;
                }
            }else {
                i++;
            }
        }
        return String.valueOf(chars);
    }
    public static boolean isVowel(char a){
        if (a=='a'||a=='e'||a=='i'||a=='o'||a=='u'||a=='A'||a=='E'||a=='I'||a=='O'||a=='U') {
            return true;
        }else {
            return false;
        }
    }
}
