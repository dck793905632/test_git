package medium;

import org.junit.Test;

import java.util.Arrays;

public class medium50 {
    @Test
    public void  test(){
        boolean[] visited = new boolean[2];
        System.out.println(Arrays.toString(visited));
    }
    public double myPow(double x, int n) {
        double res = 1.0;
        for(int i = n; i != 0; i /= 2){
            if(i % 2 != 0){
                res *= x;
            }
            x *= x;
        }
        return  n < 0 ? 1 / res : res;
    }
}
