package meituan;

import java.util.Arrays;
import java.util.Scanner;

public class Main82203 {
    static int[] arrw;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n==1){
            System.out.println(0);
        }
        arrw = new int[n];
        for(int i=0;i<n;i++){
            arrw[i]=scanner.nextInt();
        }
        int[] arri = new int[n];
        for(int i=0;i<n;i++){
            arri[i]=scanner.nextInt();
        }
        for(int i=0;i<n;i++){
            System.out.println(getMax(arri[i],arrw));
        }
    }
    public static long getMax(int index,int[] arrw){
        int i = index-1;
        arrw[i]=0;
        int pre = 0;
        int post = 0;
        for(int j=0;j<i;j++){
            pre+=arrw[j];
        }
        for(int j=i;j<arrw.length;j++){
            post+=arrw[j];
        }
        return Math.max(pre,post);
    }
}
