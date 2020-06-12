package com.atguigu.Algorithm.kmp;

public class ViolenceMatch {
    public static void main(String[] args) {
        String str1 = "abcdefghigklmn";
        String str2 ="l";
        int match = violenceMatch(str1, str2);
        System.out.println(match);
    }
    public static int violenceMatch(String str1,String str2){
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int i=0;
        int j =0 ;

        int s1Len = s1.length;
        int s2Len = s2.length;

        while (i<s1Len && j<s2Len){
            if (s1[i]==s2[j]){
                i++;
                j++;
            }else {
                i=i-(j-1);
                j=0;
            }
        }

        if (j==s2Len){
            return i-j;
        }else {
            return -1;
        }
    }
}
