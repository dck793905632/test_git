package jiuzhangsuanfa.dp;

import org.junit.Test;

public class PaintHouseII {
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
        if (cost.length==0 || cost[0].length==0){
            return 0;
        }
        int m =cost.length;
        int k = cost[0].length;//有多少栋房子
        int min1,min2;//每一行的最小值和次小值
        int i,j;
        int id1=0;//最小值和次小值的下标j
        int id2=0;//最小值和次小值的下标j
        int[][] dp = new int[m+1][k];
        for (j= 0; j <k ; j++) {
            dp[0][j]=0;
        }

        for(i=1;i<=m;i++){
            min1=min2=Integer.MAX_VALUE;
            for(j=0;j<k;j++){
                if (dp[i-1][j]<min1){
                    min2=min1;
                    id2=id1;
                    min1=dp[i-1][j];
                    id1=j;
                }else {
                    if (dp[i-1][j]<min2){
                        min2=dp[i-1][j];
                        id2=j;
                    }
                }
            }
            for(j=0;j<k;j++){
                dp[i][j]=cost[i-1][j];
                if (j!=id1){
                    dp[i][j]+=min1;
                }else {
                    dp[i][j]+=min2;
                }
            }

        }
        for(i=0;i<=m;i++){
            for(j=0;j<k;j++){
                System.out.print(dp[i][j]+ " ");
            }
            System.out.println();
        }
        int res = Integer.MAX_VALUE;
        for (i = 0;  i<k ; i++) {
            res=Math.min(res,dp[m][i]);
        }
        return res;
    }
}
