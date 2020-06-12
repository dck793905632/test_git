package top100;

import org.junit.Test;

public class medium647 {
    @Test
    public void test(){
        String s = "abcde";
        System.out.println(countSubstrings(s));
    }
    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            //分奇偶考虑
            res += countSegment(s, i, i);
            res += countSegment(s, i, i + 1);
        }
        return res;
    }

    //start往左边跑，end往右边跑, 判断s[start, end]是否为回文
    public int countSegment(String s, int start, int end) {
        int count = 0;
        while (start >= 0 && end < s.length() && s.charAt(start--) == s.charAt(end++))
            count++;
        return count;
    }

    /*
    * 暴力方法
    * public int countSubstrings(String s) {
        int res=0;
        for(int start=0;start<s.length();start++){
            for(int end=start;end<s.length();end++){
                if(isP(s,start,end)){
                    res++;
                }
            }
        }
        return res;
    }
    public boolean isP(String s,int start,int end){
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    *
    *
    * */

}
