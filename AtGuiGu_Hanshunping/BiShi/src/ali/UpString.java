package ali;

import java.util.ArrayList;
import java.util.List;

public class UpString {
    /*题意

首先定义上升字符串，s[i] >= s[i-1]，比如aaa,abc是，acb不是

给n个上升字符串，选择任意个拼起来，问能拼出来的最长上升字符串长度。

思路

动态规划，创建一个长度为26的dp[]数组，dp[i]表示以字符'a'+i结尾的最长上升字符串长度。

用一个桶，将所有字符串依据字符串末尾字符分成26份装入桶中。

对dp[i]的求法是，从第i个桶中拿出所有字符串s，设s的字符串长度为l，开头字符为c，则遍历0~c-'a'的dp数组，加上l，则构成一种情况。

对于开头字符和结尾字符相同的字符串，需要特殊处理一下，详见代码
    *
    * */
    //上升字符串最大连接，返回最大连接长度
    public int maxLengthConcat(String[] str){
        int ans = 0;
        int[] dp = new int[26];
        int[] add = new int[26];
        List<ArrayList<String>> l = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < 26; i++) {
            l.add(new ArrayList<String>());
        }

        //用桶的思想，将以(int)x结尾的字符串装到相应的桶里
        for (int i = 0; i < str.length; i++) {
            //字符结尾
            int j = str[i].charAt(str[i].length()-1) - 'a';
            //特殊情况，以x开头并以x结尾，不装入，将长度加到add数组，可以视为
            //所有以x结尾的字符串的长度，默认+add[x]
            if (str[i].charAt(0) - 'a' == j) {
                add[j] += str[i].length();
            }
            else {
                l.get(j).add(str[i]);
            }
        }

        //初始化以'a'为结尾的最长长度
        for (int i = 0; i < l.get(0).size(); i++) {
            dp[0] = Math.max(l.get(0).get(i).length(),dp[0]);
        }

        //从'a'开始更新
        for (int i = 0; i < 26; i++) {
            if (l.get(i).size() == 0 && add[i] > 0){
                for (int j = 0; j < i; j++) {
                    dp[i] = Math.max(dp[i],dp[j]);
                }
            }
            //遍历以'a'+i 为结尾的字符串
            for (int j = 0; j < l.get(i).size(); j++) {
                String s = l.get(i).get(j);
                int len = s.length();
                int c = s.charAt(0) - 'a';
                for (int k = 0; k <= c; k++) {
                    dp[i] = Math.max(dp[i], dp[k] + len);
                }
            }

            dp[i] += add[i];
        }

        for (int i = 0; i < 26; i++) {
            ans = ans > dp[i] ? ans : dp[i];
        }

        return ans;
    }
}
