package simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class simple383 {
    public static void main(String[] args) {
        System.out.println(canConstruct("", "a"));


    }
    public static boolean canConstruct(String ransomNote, String magazine) {
        StringBuilder mag = new StringBuilder(magazine);
        char[] ran = ransomNote.toCharArray();
        for (char c :ran){
            int index = mag.indexOf(String.valueOf(c));
            if (index>=0){
                mag.deleteCharAt(index);
            }else {
                return false;
            }
        }
        return true;

    }
    /*public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.equals("")&&magazine.equals("")){
            return true;
        }else if (ransomNote.equals("")&&!magazine.equals("")){
            return true;
        }else if (!ransomNote.equals("")&&magazine.equals("")){
            return false;
        }
        boolean flag=false;
        int i=0;
        int j =0;
        char[] ran = ransomNote.toCharArray();
        char[] mag = magazine.toCharArray();
        Arrays.sort(ran);
        Arrays.sort(mag);
        while (i<mag.length){
            if (mag[i]==ran[j]){
                i++;
                j++;
            }else {
                i++;
            }
            if (j==ransomNote.length()){
                return !flag;
            }
        }
        return flag;
    }*/
}
