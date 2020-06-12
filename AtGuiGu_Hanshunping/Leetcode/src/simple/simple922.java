package simple;

import java.util.Arrays;

public class simple922 {
    public static void main(String[] args) {
        int[] arr = new int[]{4,2,5,7};
        int[] ints = sortArrayByParityII(arr);
        System.out.println(Arrays.toString(ints));
    }
    public static int[] sortArrayByParityII(int[] A) {
        int j=1;

        for (int i=0;i<A.length;i+=2){
            if (A[i]%2!=0){
                while (A[j]%2!=0){
                    j+=2;
                }
                int temp=A[i];
                A[i]=A[j];
                A[j]=temp;
            }
        }
        return A;
    }
    /*public static int[] sortArrayByParityII(int[] A) {

        int[] arr = new int[A.length];
        int i=0;
        int j=1;
        for (int k = 0; k < A.length; k++) {
            if (A[k]%2==0){
                arr[i]=A[k];
                i+=2;
            }else {
                arr[j]=A[k];
                j+=2;
            }
        }
        return arr;
    }*/
}
