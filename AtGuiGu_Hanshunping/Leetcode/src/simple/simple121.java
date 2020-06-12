package simple;

import org.junit.Test;
import org.omg.CORBA.INTERNAL;

import javax.swing.text.MutableAttributeSet;

public class simple121 {
    @Test
    public void test(){
        int[] price = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(price));
    }
    /*
    * 假设当前在第 i 天，令 minPrice 表示前 i-1 天的最低价格；令 maxProfit 表示前 i-1 天的最大收益。那么考虑第 i 天的收益时，存在两种情况：

在第 i 天卖出。很显然，想要获得最大收益，应该在前 i-1 天中价格最低的时候买入，即此时的收益为：prices[i] - minPrice。（可能会出现负数，但是没关系）
不在第 i 天卖出。那么第 i 天的最大收益就等于前 i -1 天中的最大收益
状态转移方程为：第 i 天最大收益 = max( 在第 i 天卖出的所得收益 , 前 i-1 天的最大收益)
    * */

    public int maxProfit(int[] prices) {
        int minProfit=Integer.MAX_VALUE;
        int maxProfit=0;

        for (int i = 0; i < prices.length; i++) {
            minProfit=Math.min(prices[i],minProfit);
            maxProfit=Math.max(prices[i]-minProfit,maxProfit);
        }
        return maxProfit;
    }

    /*public int maxProfit(int[] prices) {
        int max=0;
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i]<min){
                min=prices[i];
            }else {
                if (max<prices[i]-min){
                    max=prices[i]-min;
                }
            }
        }
        return max;
    }*/
    /*public int maxProfit(int[] prices) {
        int max=0;
        for (int i = 0; i < prices.length-1; i++) {
            for (int j = i+1; j < prices.length; j++) {
                if (prices[j]-prices[i]>max){
                    max=prices[j]-prices[i];
                }
            }
        }
        return max;
    }*/
}
