package jiuzhangsuanfa.dp;

import org.junit.Test;

public class PaintHouse {

    @Test
    public void test(){
        int[][] cost = new int[][]{
                {14,2,11},
                {11,14,5},
                {14,3,10}
        };
        System.out.println(costMin(cost));
    }
    public int costMin(int[][] cost){
        int n =cost.length;
        if (n==0){
            return 0;
        }
        int[][] dp =new int[n+1][3];

        dp[0][0]=dp[0][1]=dp[0][2]=0;
        for (int i = 1; i <=n; i++) {
            //倒数第一房子的颜色 j
            for (int j = 0; j < 3; j++) {
                dp[i][j]=Integer.MAX_VALUE;
                //倒数第二房子的颜色 k
                for (int k = 0; k < 3; k++) {
                    if (j!=k){
                        dp[i][j]=Math.min(dp[i][j],dp[i-1][k]+cost[i-1][j]);
                    }
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return Math.min(dp[n][0],Math.min(dp[n][1],dp[n][2]));
    }
}
