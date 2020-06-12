package zhaohangkazhongxin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        List<Integer> res = new ArrayList<>();
        for(int k=0;k<T;k++){
            int n = scanner.nextInt();
            int[] arr = new int[n];
            int sum=0;
            for(int i=0;i<n;i++){
                arr[i]=scanner.nextInt();
                sum+=arr[i];
            }
            if(n+1<sum){
                res.add(n+1);
            }else {
                res.add(-1);
            }

        }
        for(int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }


    }
}
