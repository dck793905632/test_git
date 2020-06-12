package jiuzhangsuanfa.towpoints;

import org.junit.Test;

import java.util.Arrays;

public class WindowSum {
    /**
     * 同向双指针
     * 描述
     * 中文
     * 英语
     * 给定一个由n个整数组成的数组和一个移动窗口（大小为k），请从数组开始处在每次迭代sum时移动窗口，并在每次移动时找到窗口内部元素的。
     *
     * 您是否在一次真实采访中遇到了这个问题？
     * 例
     * 例子1
     *
     * Input：array = [1,2,7,8,5], k = 3
     * Output：[10,17,20]
     * Explanation：
     * 1 + 2 + 7 = 10
     * 2 + 7 + 8 = 17
     * 7 + 8 + 5 = 20
     * */
    @Test
    public void test(){
        int[] num = new int[]{1,2,7,8,5};
        int[] ints = minSum(num, 3);
        System.out.println(Arrays.toString(ints));

    }
    public int[] minSum(int[] num,int k){
        int[] arr = new int[num.length-k+1];
        int i=0;
        int j=i+k;
        int sum=0;
        int index=0;
        while(j<=num.length){
            for (i=index;i<j;i++){
                sum+=num[i];
            }
            arr[index]=sum;
            sum=0;
            index++;
            j++;
        }
        return arr;
    }
}
