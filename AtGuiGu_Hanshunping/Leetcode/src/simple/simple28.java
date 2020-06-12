package simple;

import java.util.Arrays;

public class simple28 {
    public static void main(String[] args) {
        String haystack ="a";
        String needle ="a";
        int i = strStr(haystack, needle);
        System.out.println(i);


    }
/*
    public static int strStr(String haystack, String needle) {
        int i =0;
        int j =0;
        char[] chars1 = haystack.toCharArray();
        char[] chars2 = needle.toCharArray();
        while (i<chars1.length && j <chars2.length){
            if (chars1[i]==chars2[j]){
                i++;
                j++;
            }else{
                i=i-(j-1);
                j=0;
            }
        }
        if (j==chars2.length){
            return i-(j-1)-1;
        }else {
            return -1;
        }
    }
*/

    public static int strStr(String haystack, String needle) {
        return kmpSearch(haystack,needle,kmpNext(needle));
    }
    public static int kmpSearch(String str1,String str2,int[] next){

        if (next==null){
            return 0;
        }
        for (int i=0,j=0;i<str1.length();i++){
            while (j>0 &&str1.charAt(i)!=str2.charAt(j)){
                j=next[j-1];
            }
            if (str1.charAt(i)==str2.charAt(j)){
                j++;
            }
            if (j==str2.length()){
                return i-j+1;
            }

        }
        return -1;
    }
    public static int[] kmpNext(String dest){
        if (dest.length()==0){
            return null;
        }
        char[] chars = dest.toCharArray();
        int[] next = new int[dest.length()];
        next[0]=0;
        for (int i=1,j=0;i<dest.length();i++){
            while (j>0&&chars[i]!=chars[j]){
                j=next[j-1];
            }
            if (chars[i]==chars[j]){
                j++;
            }
            next[i]=j;
        }
        return next;
    }
}
