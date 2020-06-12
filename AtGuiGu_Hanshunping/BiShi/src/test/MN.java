package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MN {
    static String[] room = {"A", "B", "C"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(",");
        int[] a = new int[strs.length];
        int k = 0;
        for (int i = 0; i < strs.length; i++) {
            a[i] = Integer.parseInt(strs[i]);
            k ^= a[i];
        }

        if (k == 0) {
            //P-position，先手必败
            System.out.println(1);
        } else {
            //N-position，先手必胜
            for (int i = 0; i < a.length; i++) {
                //寻找N-position移动到某个P-position的方法
                int num = k ^ a[i], tmpXor = num ^ num;
                if (a[i] - num >= 0 && tmpXor == 0) {
                    System.out.println(room[i] + "," + (a[i] - num));
                    break;
                }
            }
        }
    }
}
