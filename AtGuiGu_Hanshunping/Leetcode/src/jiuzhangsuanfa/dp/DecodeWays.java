package jiuzhangsuanfa.dp;

public class DecodeWays {
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int n =chars.length;
        int[] dp = new int[n+1];
        dp[0]=1;

        for(int i=1;i<=n;i++){
            if(chars[i-1]>='1' && chars[i-1]<='9'){
                dp[i]+=dp[i-1];
            }
            if(i>1){
                int j =10*(chars[i-2]-'0')+(chars[i-1]-'0');
                if(j>=10 && j<=26){
                    dp[i]+=dp[i-2];
                }
            }
        }
        return dp[n];
    }
}
