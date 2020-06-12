package simple;

import java.lang.reflect.Array;
import java.util.Arrays;

public class simple434 {
    public static void main(String[] args) {
        System.out.println(countSegments(""));
    }
    public static int countSegments(String s) {

        String str = s.trim();
        if (str.length()==0){
            return 0;
        }
        String[] split = str.split("\\s+");
        return split.length;
    }
}
