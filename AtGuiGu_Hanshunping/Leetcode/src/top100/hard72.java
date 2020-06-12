package top100;

import org.junit.Test;

public class hard72 {
    @Test
    public void test(){
        String word1 = "horse";
        String word2 =  "ros";
        System.out.println(minDistance(word1,word2));
    }
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if(n*m==0){
            return m+n;
        }
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=i;
        }
        for(int j=0;j<=m;j++){
            dp[0][j]=j;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                int left = dp[i][j-1]+1;
                int up = dp[i-1][j]+1;
                int upleft = dp[i-1][j-1];
                if(word1.charAt(i-1)!=word2.charAt(j-1)){
                    upleft+=1;
                }
                dp[i][j]=Math.min(left,Math.min(up,upleft));
            }
        }
        return dp[n][m];
    }

}






























