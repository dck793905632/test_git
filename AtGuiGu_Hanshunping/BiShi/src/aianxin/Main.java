package aianxin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] val ={2,3,1,5,4,3};
        int[] count = {2,2,3,1,5,2};
        int n=val.length;
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[][] dp=new int[n+1][N+1];
        for (int i=1;i<dp.length;i++){
            for (int j = 1; j < dp[0].length; j++) {
                if (count[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }else {
                    if (dp[i-1][j]<val[i-1]+dp[i-1][j-count[i-1]]){
                        dp[i][j]=val[i-1]+dp[i-1][j-count[i-1]];
                    }else {
                        dp[i][j]=dp[i-1][j];
                    }
                }
            }
        }

        System.out.println(dp[n][N]);
    }
}
