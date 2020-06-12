package simple;

import java.math.BigInteger;

public class simple07 {
    public static void main(String[] args) {
       // int x = 1534236469;
        int x = 123;
        int res = reverse(x);
        System.out.println(res);
    }
    public static int reverse(int x) {
       int ret = 0;
       while (x!=0){
           int temp = ret*10 +x%10;
           if (temp/10!=ret){//判断是否溢出
               return 0;
           }
           ret = temp;
           x=x/10;
       }
       return ret;
    }
}
