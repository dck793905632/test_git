package com.atguigu.sparsearray;

import org.junit.Test;

public class SparseArray2 {
    public static void main(String[] args) {
        //定义矩阵
        int chessArr[][] = new int[10][11];
        chessArr[0][1]=2;
        chessArr[4][5]=2;
        chessArr[3][8]=2;

        System.out.println("输出原始数组");
        for (int[] row : chessArr) {
            for (int value : row){
                System.out.print(value+" ");
            }
            System.out.println();
        }

        System.out.println("输出压缩后的矩阵");
        int count=0;
        for (int[] row : chessArr){
            for (int value:row){
                if (value!=0){
                    count++;
                }
            }
        }
        int sparseArr[][] =new int[count+1][3];
        sparseArr[0][0]=10;
        sparseArr[0][1]=11;
        sparseArr[0][2]=count;
        int index=1;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr[i][j]!=0){
                    sparseArr[index][0]=i;
                    sparseArr[index][1]=j;
                    sparseArr[index][2]=chessArr[i][j];
                    index++;
                }
            }
        }

        for (int[] row : sparseArr){
            for (int value : row){
                System.out.print(value+" ");
            }
            System.out.println();
        }


        System.out.println("解压压缩矩阵");
        int[][] newchessArr = new int[sparseArr[0][0]][sparseArr[0][1]];

        for (int i =1 ; i<sparseArr[0][2];i++){
                newchessArr[sparseArr[i][0]][sparseArr[i][1]]=sparseArr[i][2];
        }
        for (int[] row : newchessArr){
            for (int value : row){
                System.out.print(value+" ");
            }
            System.out.println();
        }

    }


}
