package com.atguigu.Algorithm.dynamic;

public class KanpsackProblem {
    public static void main(String[] args) {
        int[] w ={1,4,3};//物品的重量
        int[] val = {1500,3000,2000};//对应的价值，这里的val 对应公式的v[i]
        int m=4;//背包的容量
        int n=val.length;//物品的个数

        int[][] v= new int[n+1][m+1];

        int[][] path=new int[n+1][m+1];

//        //初始化第一行和第一列
//        for (int i = 0; i < m + 1; i++) {
//            v[0][i]=0;
//        }
//        for (int i = 0; i < n + 1; i++) {
//            v[i][0]=0;
//        }

        //根据公式处理
        for (int i=1;i<v.length;i++){
            for (int j = 1; j < v[0].length; j++) {
                if (w[i-1]>j){
                    v[i][j]=v[i-1][j];
                }else {
                    //v[i][j]=Math.max(v[i-1][j],val[i-1]+v[i-1][j-w[i-1]]);
                    if (v[i-1][j]<val[i-1]+v[i-1][j-w[i-1]]){
                        v[i][j]=val[i-1]+v[i-1][j-w[i-1]];
                        path[i][j]=1;
                    }else {
                        v[i][j]=v[i-1][j];
                    }
                }
            }
        }

        //输出二维数组
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                System.out.print(v[i][j]+" ");
            }
            System.out.println();
        }

        int i = path.length-1;
        int j = path[0].length-1;
        while ( i>0 && j>0){
            if (path[i][j]==1){
                System.out.println(i);
                j--;
            }
            i--;
        }
    }
}
