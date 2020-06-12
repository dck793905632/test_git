package ali;

public class Pukepai {
    /*
    * 有一叠扑克牌，每张牌介于1和10之间

有四种出牌方法：

单出一张
出两张相同的牌(对子)
出五张顺子(如12345)
出三连对子(如112233)
给10个数，表示1-10每种牌有几张，问最少要多少次能出完

思路

暴力+回溯，从最小的牌开始出，分别判断四种情况能不能出，若能出，则去除掉出的牌，变成问题模型相同，规模更小的子问题求解。

card数组长度为10，card[i]表示牌号为"i+1"的牌的数量。
    * */
    //打牌
    public int Poker(int[] cards){
        return subPoker(cards,0);
    }

    private int subPoker(int[] cards, int k){
        int ans = Integer.MAX_VALUE;
        if (k >= cards.length) {
            return 0;
        }
        //当前牌出完，出下一张
        else if (cards[k] == 0){
            return subPoker(cards,k+1);
        }
        //出连对
        if (k <= cards.length - 3 && cards[k] >= 2 && cards[k+1] >= 2 && cards[k+2] >=2){
            cards[k] -= 2;
            cards[k+1] -= 2;
            cards[k+2] -= 2;
            ans = Math.min(1+subPoker(cards,k),ans);
            cards[k] += 2;
            cards[k+1] += 2;
            cards[k+2] += 2;
        }
        //出顺子
        if (k <= cards.length - 5 && cards[k] >= 1 && cards[k+1] >= 1 && cards[k+2] >=1 && cards[k+3] >= 1 && cards[k+4] >= 1){
            cards[k] -= 1;
            cards[k+1] -= 1;
            cards[k+2] -= 1;
            cards[k+3] -= 1;
            cards[k+4] -= 1;
            ans = Math.min(1+subPoker(cards,k),ans);
            cards[k] += 1;
            cards[k+1] += 1;
            cards[k+2] += 1;
            cards[k+3] += 1;
            cards[k+4] += 1;
        }
        //出对子
        if (cards[k] >= 2){
            cards[k] -= 2;
            ans = Math.min(1+subPoker(cards,k),ans);
            cards[k] += 2;
        }
        //出单牌
        if (cards[k] >= 1){
            cards[k] -= 1;
            ans = Math.min(1+subPoker(cards,k),ans);
            cards[k] += 1;
        }

        return ans;

    }
}
