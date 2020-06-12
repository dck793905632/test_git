package jiuzhangsuanfa.dp;

import org.junit.Test;

import java.util.Arrays;

public class medium132 {
    @Test
    public void test(){
        String s = "aaab";
        System.out.println(minCut(s));
    }

    public int minCut(String s) {
        char[] chars = s.toCharArray();
        int n =chars.length;
        if(n==0){
            return 0;
        }
        boolean[][] isPalin = calcPain(chars);
        int[] dp = new int[n+1];
        dp[0]=0;
        for(int i=1;i<=n;i++){
            dp[i]=Integer.MAX_VALUE;
            for (int j=0;j<i;j++){
                if (isPalin[j][i-1]){
                    dp[i]=Math.min(dp[i],dp[j]+1);
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n]-1;
    }
    public boolean[][] calcPain(char[] s){
        int n = s.length;
        boolean[][] f = new boolean[n][n];
        int i,j,c;
        /*for (i=0;i<n;i++){
            for(j=0;j<n;j++){
                f[i][j]=false;
            }
        }*/
        //奇数位
        for(c=0;c<n;c++){
            i=j=c;
            while (i>=0 && j<n && s[i]==s[j]){
                f[i][j]=true;
                i--;
                j++;
            }
        }
        //偶数位
        for (c=0;c<n;c++){
            i=c;
            j=c+1;
            while(i>=0 && j<n && s[i]==s[j]){
                f[i][j]=true;
                i--;
                j++;
            }
        }
        return f;
    }
}
