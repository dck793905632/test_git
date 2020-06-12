package simple;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

public class simple520 {
    public static void main(String[] args) {
        String str="Uaa";
        System.out.println(detectCapitalUse(str));
    }
    public static boolean detectCapitalUse(String word) {
        char[] chars = word.toCharArray();
        int lower=0;
        int upper=0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]>='a'&&chars[i]<='z'){
                lower++;
            }else if (chars[i]>='A'&&chars[i]<='Z'){
                upper++;
            }
        }
        if (lower==chars.length){
            return true;
        }else if (upper==chars.length){
            return true;
        }else if (chars[0]>='A'&&chars[0]<='Z' && lower==chars.length-1){
            return true;
        }else {
            return false;
        }



    }
}
