package test;

import com.sun.tracing.dtrace.ArgsAttributes;

import java.util.Arrays;

public class SomeTest {
    public static void main(String[] args) {
        String str = "aaabbb";
        int[] arr = new int[26];
        for(int i=0;i<str.length();i++){
            arr[str.charAt(i)-'a']+=1;
        }
        System.out.println(Arrays.toString(arr));

    }
}
