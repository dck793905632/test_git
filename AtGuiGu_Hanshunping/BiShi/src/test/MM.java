package test;

import java.util.Scanner;
/*
* 链接：https://www.nowcoder.com/questionTerminal/cfb7734a7c844350895f2e269a38195d
来源：牛客网

某公司年会上，组织人员安排了一个小游戏来调节气氛。游戏规则如下：

N个人参与游戏，站成一排来抢工作人抛来的M个小玩偶。为了增加游戏的趣味和难度，规则规定，参与游戏的人抢到的礼物不能比左右两边的人多两个或以上，否则会受到一定的惩罚。游戏结束时拥有玩偶最多的人将获得一份大奖。
假设大家都想赢得这份大奖，请问站在第K个位置的小招在赢得游戏时，最多能拥有几个玩偶？

输入描述:
输入为用空格分隔的3个正整数，依次为：参与游戏人数N、玩偶数M、小招所在位置K


输出描述:
输出为1个正整数，代表小招最多能够拥有的玩偶数。若没有，则输出0。
* */
public class MM {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();
            get(n,m,k);
        }
    }
    public static  void get(int n ,int m,int k){
        // 特殊情况
        if(n==0 || m==0 || k<=0 || k>n) {
            System.out.println(0);
        } else {
            // 参与游戏的人抢到的礼物不能比左右两边的人多两个或以上
            // 即小招左右两边的人最少分别为小招的玩偶数减一，即max-1
            // 为了让小招玩偶数尽量多，离校招越远的人玩偶数越少，呈依次减一的情形
            for (int max = m; max >0; max--) {
                int sum = max;
                for (int i = 1; i <= k-1; i++) {
                    sum += (max-i)>0?(max-i):0;
                }
                for (int i = 1; i <= n-k; i++) {
                    sum += (max-i)>0?(max-i):0;
                }
                if(sum<=m) {
                    System.out.println(max);
                    break;
                }
            }
        }
    }

}
