package rabinkarp;

import org.junit.Test;

public class strStr {
    final int BASE=1000000;

    @Test
    public  void  test(){
        String str1 = "hello";
        String str2 = "ll";
        System.out.println(strStr(str1,str2));
    }
    public  int strStr(String haystack, String needle) {
        if(haystack==null || needle ==null){
            return -1;
        }
        int m = needle.length();
        //31^m
        int power=1;
        for(int i=0;i<m;i++){
            power=(power*31)%BASE;
        }

        int targetCode=0;
        for(int i=0;i<m;i++){
            targetCode=(targetCode*31+needle.charAt(i))%BASE;
        }
        int hashCode=0;
        for(int i=0;i<haystack.length();i++){
            hashCode=(hashCode*31+haystack.charAt(i))%BASE;
            if(i<m-1){
                continue;
            }
            if(i>=m){
                hashCode=hashCode-(haystack.charAt(i-m)*power)%BASE;
                if(hashCode<0){
                    hashCode+=BASE;
                }
            }
            if(hashCode==targetCode){
                if(haystack.substring(i-m+1,i+1).equals(needle)){
                    return i-m+1;
                }
            }
        }
        return -1;

    }
}
