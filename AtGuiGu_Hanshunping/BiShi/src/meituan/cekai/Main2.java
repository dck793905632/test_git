package meituan.cekai;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int m = scanner.nextInt();
            int q = scanner.nextInt();
            int p = scanner.nextInt();

            int[] arr = new int[k];
            for(int i=0;i<k;i++){
                arr[i]=scanner.nextInt();
            }

            int sum=0;
            for (int i = 0; i < k; i++) {
                sum+=arr[i];
            }
            if(m>=sum){
                System.out.println(k*q+p);
            }else {
                System.out.println(q);
            }

        }
    }

}
