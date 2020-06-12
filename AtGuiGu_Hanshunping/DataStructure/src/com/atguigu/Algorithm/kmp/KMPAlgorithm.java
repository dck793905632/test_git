package com.atguigu.Algorithm.kmp;

import java.util.Arrays;

public class KMPAlgorithm {
    public static void main(String[] args) {
//        String str1 = "BBC ABCDAB ABCDABCDABDE";
//        String str2 = "ABCDABD";
        //String str2 = "A";
        //int i = kmpSearch(str1, str2, kmpNext(str2));
        //System.out.println(i);
        String str1 ="a";
        String str2 ="a";
        int i = kmpSearch(str1, str2, kmpNext(str2));
        System.out.println(i);


    }
    public static int kmpSearch(String str1,String str2,int[] next){

        for (int i=1,j=0;i<str1.length();i++){
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
