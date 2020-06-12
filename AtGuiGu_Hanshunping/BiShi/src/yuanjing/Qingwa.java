package yuanjing;

import java.util.Scanner;

public class Qingwa {
    public static long countWays(int n) {
        int[] res = {0, 1};
        if(n < 3) {
            System.out.println(res[n-1]);
            return res[n-1];
        }
        long one = 1;
        long two = 1;
        long result = 0;
        for(int i = 3; i <= n; i++) {
            result = (one + two) % 1000000007;
            one = two;
            two = result;
        }
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        countWays(n);
    }
}
