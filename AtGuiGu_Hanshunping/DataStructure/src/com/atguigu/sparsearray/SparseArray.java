package com.atguigu.sparsearray;

import org.junit.Test;

public class SparseArray {
    public static void main(String[] args) {
        //创建棋盘数组
        //1 表示黑子 2 表示蓝子 0表示无子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2]=1;
        chessArr1[2][3]=2;
        chessArr1[4][5]=2;

        //遍历棋盘初始
        for (int[] row : chessArr1){
            for(int data: row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        System.out.println("矩阵压缩");
        int sum=0;
        for(int[] row :chessArr1){
            for (int data : row){
                if (data!=0){
                  sum++;
                }
            }
        }
        //System.out.println("sum="+sum);

        int count=0;
        //定义稀疏数组
        int sparseArr[][] = new int[sum+1][3];
        sparseArr[0][0]=11;
        sparseArr[0][1]=11;
        sparseArr[0][2]=sum;
        for(int i=0;i<11;i++){
            for (int j=0;j<11;j++){
                if (chessArr1[i][j]!=0){
                    count++;
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=chessArr1[i][j];
                }
            }
        }
        //遍历稀疏矩阵
        for (int[] row : sparseArr){
            for (int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //稀疏矩阵还原
        System.out.printf("矩阵还原");
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i=1;i<sparseArr.length;i++){
            chessArr2[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }
        for (int[] row : chessArr2){
            for (int data:row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

    }

    @Test
    public void test1(){
        int arr[][] = new int[20][3];
        System.out.println(arr.length);
    }
}
