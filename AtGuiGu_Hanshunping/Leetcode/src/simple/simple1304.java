package simple;

import java.util.Arrays;

public class simple1304 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumZero(4)));
    }
    public static int[] sumZero(int n) {
        int[] arr= new int[n];
        int r=0;
        int l=0;
        int len=n-1;
        for(int i=0;i<n/2;i++){
            arr[i]=l-1;
            arr[len]=r+1;
            r++;
            l--;
            len--;
        }
        return arr;
    }
}
