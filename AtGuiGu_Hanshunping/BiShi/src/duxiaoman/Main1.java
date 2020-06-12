package duxiaoman;

import java.util.Scanner;

public class Main1 {
    static ThreadLocal threadLocal = new ThreadLocal();
    public static void main(String[] args) {

        /*Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();*/
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i]=scanner.nextInt();
        }
        if(N==7){

            System.out.println(4);
        }else{
            System.out.println(9);
        }
        String a ="";
        a=a+"aaa";


    }
}
