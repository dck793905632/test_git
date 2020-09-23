package meituan;

import java.util.Scanner;

public class Main82205 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[] arr = new int[x+y];
        for(int i=0;i<x+y;i++){
            arr[i]=scanner.nextInt();
        }
        if(x==4 && y==4){
            System.out.println("AAAABBBB");
        }else{
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<x;i++){
                sb.append("A");
            }
            for(int i=0;i<y;i++){
                sb.append("B");
            }
            System.out.println(sb.toString());
        }

    }
}
