package meituan.cekai;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] arr1 = new int[n];
            for(int i=0;i<n;i++){
                arr1[i]=scanner.nextInt();
            }
            int[] arr2 = new int[n];
            for(int i=0;i<n;i++){
                arr2[i]=scanner.nextInt();
            }
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            int sum1 = arr1[n-1]+arr1[n-2]+arr1[n-3];
            int sum2 = arr2[n-1]+arr2[n-2]+arr2[n-3];
            System.out.println(Math.max(sum1,sum2));
        }
    }

}
