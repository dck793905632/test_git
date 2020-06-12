package kuaishou;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String substring = str.substring(1, str.length() - 1);
        String[] strs = substring.split(",");
        int[] arr = new int[strs.length];
        for(int i=0;i<arr.length;i++){
            arr[i]=Integer.valueOf(strs[i]);
        }
        int[] res = Dis(arr);
        System.out.println(Arrays.toString(res));



    }
    public static int[] Dis(int[] arr){
        int[] res = new int[arr.length];
        res[0]=0;
        for(int i=1;i<arr.length;i++){
            for (int j = 0; j < i; j++) {
                if(arr[j]>arr[i]){
                    res[i]=i-j;
                }
            }
        }
        return res;

    }
}
