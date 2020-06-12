package medium;

import org.junit.Test;

public class medium62 {
    @Test
    public void test(){
        System.out.println(uniquePaths(3,2));
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0]=1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i+1<m){
                    dp[i+1][j]+=dp[i][j];
                }
                if (j+1<n){
                    dp[i][j+1]+=dp[i][j];
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }
        return dp[m-1][n-1];
    }
}
