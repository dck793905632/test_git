package jiuzhangsuanfa.dp;

import org.junit.Test;

public class BombEnemy {
    @Test
    public void test(){
        char[][] A = new char[][]{
                {'0','E','0','0'},
                {'E','0','W','E'},
                {'0','E','0','0'},
        };
        System.out.println(num(A));
    }
    public int num(char[][] A){
        if (A.length==0 || A[0].length==0 || A==null){
            return 0;
        }
        int m = A.length;
        int n = A[0].length;
        int[][] up = new int[m][n];
        int[][] down = new int[m][n];
        int[][] left = new int[m][n];
        int[][] right = new int[m][n];
        int res =0;

        //往上数
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j]=='W'){
                    up[i][j]=0;
                    continue;
                }
                up[i][j]=A[i][j]=='E'?1:0;
                if (i>0){
                    up[i][j]+=up[i-1][j];
                }
            }
        }
        //往下数
        for (int i = m-1; i >=0; i--) {
            for (int j = 0; j < n; j++) {
                if (A[i][j]=='W'){
                    down[i][j]=0;
                    continue;
                }
                down[i][j]=A[i][j]=='E'?1:0;
                if (i<m-1){
                    down[i][j]+=down[i+1][j];
                }
            }
        }
        //往右数
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j]=='W'){
                    right[i][j]=0;
                    continue;
                }
                right[i][j]=A[i][j]=='E'?1:0;
                if (j>0){
                    right[i][j]+=right[i][j-1];
                }
            }
        }

        //往左数
        for (int i = 0; i < m; i++) {
            for (int j = n-1; j >=0; j--) {
                if (A[i][j]=='W'){
                    left[i][j]=0;
                    continue;
                }
                left[i][j]=A[i][j]=='E'?1:0;
                if (j<n-1){
                    left[i][j]+=left[i][j+1];
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j]=='0'){
                    int count = up[i][j]+down[i][j]+left[i][j]+right[i][j];
                    res = Math.max(count,res);
                }
            }
        }
        return res;

    }
}
