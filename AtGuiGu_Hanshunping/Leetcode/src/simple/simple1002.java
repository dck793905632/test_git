package simple;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class simple1002 {
    public static void main(String[] args) {
        String[] A={"bella","label","roller"};
        List<String> list = commonChars(A);
        System.out.println(list);
    }
    public static List<String> commonChars(String[] A) {
        List<String> list =new ArrayList<>();
        int[] arr = new int[26];
        for (int i=0;i<A[0].length();i++){
            arr[A[0].charAt(i)-'a']++;
        }

        for (int i=1;i<A.length;i++){
            int[] temp = new int[26];
            for (int j = 0; j < A[i].length(); j++) {
                temp[A[i].charAt(j)-'a']++;
            }
            for (int k=0;k<26;k++){
                arr[k]=Math.min(arr[k],temp[k]);
            }

        }


        for (int j=0;j<26;j++){

            int len = arr[j];

            for (int k=0;k<len;k++){
                list.add((char)(j+'a')+"");
            }
        }

        return list;
    }
}
