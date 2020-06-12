package baidu;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n+1];
        int[] b = new int[n+1];
        for(int i=1;i<=n;i++){
            a[i]=scanner.nextInt();
        }
        for(int i=1;i<=n;i++){
            b[i]=scanner.nextInt();
        }
        for(int i=1;i<=n;i++){
            for (int j = i+1; j <=n; j++) {
                if(b[i]<b[j]){
                    int tmp1 =b[i];
                    b[i]=b[j];
                    b[j]=tmp1;
                    int tmp2=a[i];
                    a[i]=a[j];
                    a[j]=tmp2;
                }
            }
        }
        int[][] dp = new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=Math.min(m,i);j++){
                dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-1]+a[i]-b[i]*(j-1));
            }
        }
        System.out.println(dp[n][m]);

     }

}
