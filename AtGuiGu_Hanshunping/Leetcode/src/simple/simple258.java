package simple;

public class simple258 {
    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }
    public static int addDigits(int num) {
        if (num<10){
            return num;
        }
        int sum=0;
        while (num!=0){
            int i = num % 10;
            sum+=i;
            num=num/10;
        }
        return addDigits(sum);
    }
    /**
     * 找规律。假设 num = 384 = 3 * 100 + 8 * 10 + 4
     * 第一轮计算   sum = 15  = 3       + 8      + 4
     *             差值       = 3 * 99  + 8 * 9     = (3 * 11 + 8) * 9 即差值为9的倍数
     * 第二轮计算   num = 15 = 1 * 10 + 5
     *             sum = 6  = 1 * 0  + 5
     *             差值 = 9
     * 由此得出规律：num % 9
     * 注意：需要注意 9 的整倍数最终结果应该返回9，小于10的数直接返回
     *
     * @param num
     * @return
     */
    public static int addDigits3(int num) {
        if (num < 10) {
            return  num;
        }
        int res = num % 9;
        if (res == 0) {
            return 9;
        }
        return res;
    }
}
