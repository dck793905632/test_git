package medium;

import org.junit.Test;

public class medium63 {
    @Test
    public void test(){
        int[][] a = new int[][]{{0,0},{1,0}};
        System.out.println(uniquePathsWithObstacles(a));
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (m==0){
            return 0;
        }
        if (n==0){
            return 0;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                    continue;
                }
                if (i==0 || j==0){
                    dp[i][j]=1;
                    continue;
                }
                dp[i][j]=0;
                if (i>0){
                    dp[i][j]+=dp[i-1][j];
                }
                if (j>0){
                    dp[i][j]+=dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
    /*public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        if (obstacleGrid[0][0]==1 || obstacleGrid[m-1][n-1]==1){
            return 0;
        }
        int[][] dp = new int[m][n];
        dp[0][0]=1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j]==1){
                    continue;
                }
                if (i+1<m){
                    dp[i+1][j]+=dp[i][j];
                }
                if (j+1<n){
                    dp[i][j+1]+=dp[i][j];
                }
            }
        }
        return dp[m-1][n-1];
    }*/
}
