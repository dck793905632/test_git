package simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class simple387 {
    public static void main(String[] args) {
        char a ='9';
        char b ='5';
        int i = a + b;
        System.out.println(a+b);
    }
    public static int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])){
                map.put(chars[i],1);
            }else {
                map.put(chars[i],map.get(chars[i])+1);
            }
        }
        for (int i=0;i<chars.length;i++){
            if (map.get(chars[i])==1){
                return i;
            }
        }

        return -1;
    }
    /*public static int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int[] freq = new int[26];
        for (int i=0;i<chars.length;i++){
            freq[chars[i]-'a']++;
        }
        for (int i =0;i<chars.length;i++){
            if (freq[chars[i]-'a']==1){
                return i;
            }
        }

        return -1;
    }*/
}
