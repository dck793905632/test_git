package simple;

import java.util.ArrayList;
import java.util.List;

public class simple728 {
    public static void main(String[] args) {
        //System.out.println(selfDividingNumbers(1,22));
        System.out.println('c'-97);
    }
    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();

        while (left<=right){
            if (isDev(left)){
                list.add(left);
            }
            left++;
        }
        return list;
    }
    public static boolean isDev(int n){
        int m=n;
        while (m!=0){
            int x = m % 10;
            if (x==0){
                return false;
            }
            if (n%x!=0){
                return false;
            }
            m=m/10;
        }
        return true;
    }
}
