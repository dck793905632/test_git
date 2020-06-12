package jiuzhangsuanfa.dp;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
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
    }
}
