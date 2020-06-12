package meituan.yuanyuanlin;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }

        Arrays.sort(arr);
        int i=0;
        int j=n-1;
        int c1=0;
        int c2=0;
        while (i<j){
            while (i<j && arr[j]-arr[i]>x){
                i++;
                c1++;
            }
            i=0;
            while (i<j && arr[j]-arr[i]>x){
                j--;
                c2++;
            }
            break;
        }
        System.out.println(Math.min(c1,c2));

    }
}
