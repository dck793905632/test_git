package jiuzhangsuanfa.dp;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDoll {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes==null || envelopes.length==0){
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }else {
                    return o1[0]-o2[0];
                }
            }
        });

        int[] dp = new int[envelopes.length];
        int res=0;
        for (int j = 0; j < envelopes.length; j++) {
            dp[j]=1;
            for (int i = 0; i < j; i++) {
                if (envelopes[i][0]<envelopes[j][0] && envelopes[i][1]<envelopes[i][1]){
                    dp[j]=Math.max(dp[j],dp[i]+1);
                }
            }
            res = Math.max(res,dp[j]);

        }
        return res;
    }
}
