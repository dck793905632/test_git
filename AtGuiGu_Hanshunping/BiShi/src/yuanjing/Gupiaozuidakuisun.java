package yuanjing;

import org.junit.Test;

public class Gupiaozuidakuisun {

    @Test
    public void test(){
        int[] prices = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }


    public int maxProfit(int[] prices) {
        int max=0;
        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i+1]-prices[i]<0){
                max+=prices[i+1]-prices[i];
            }
        }
        return max;
    }


    /*
    *

#include <iostream>
#include <vector>
#include <algorithm>
#include <sstream>

using namespace std;
int MaxKui(vector<int>& prices) {
        if(prices.empty()) return 0;
        int i = 0;
        int peak = prices[0];
        int valley = prices[0];
        int profit = 0;
        while(i < prices.size() - 1)
        {
            while(i < prices.size() - 1 && prices[i + 1] <= prices[i])
            {
                i++;
            }
            valley = prices[i];
            while(i < prices.size() - 1 && prices[i + 1] > prices[i])
            {
                i++;
            }
            peak = prices[i];
            profit += (peak - valley);
        }
        return profit;
    }


int main()
{
    string str="";
    cin>>str;
    str+=',';
    istringstream is(str);
    vector<int> arr;
    int tmp;
    char c;
    while(is>>tmp>>c)
    {
        arr.emplace_back(tmp);
    }
    reverse(arr.begin(),arr.end());

    if(MaxKui(arr)<0)
    {
        cout<<0<<endl;
    }else
    cout<<MaxKui(arr)<<endl;

    return 0;
}
    *
    * */
}
