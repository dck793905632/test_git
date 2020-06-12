package meituan.kaifa;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[][] board = new String[2][n];
        for(int i=0;i<2;i++){
            for(int j=0;j<n;j++){
                String next = scanner.next();
                board[i][j]=next;
            }
        }
        for(int i=0;i<2;i++){
            for(int j=0;j<n;j++){
                System.out.println(board[i][j]);
            }
        }

        int helper = helper(board);
        System.out.println(helper);
    }
    public static int helper(String[][] board){
        int[][] dp = new int[board.length][board[0].length];
        for(int k=0;k<board[0].length;k++){
            if (board[0][k].equals(".")){
                dp[0][k]=1;
            }else {
                dp[0][k]=0;
                break;
            }
        }
        for(int k=0;k<board.length;k++){
            if(!board[k][0].equals(".")){
                dp[k][0]=0;
                break;
            }else {
                dp[k][0]=1;
            }
            for(int i=1;i<board.length;i++){
                for(int j=1;j<board[0].length;j++){
                    if(!board[i][j].equals(".")){
                        dp[i][j]=0;
                    }else {
                        dp[i][j]=(dp[i-1][j]+dp[i][j-1])%1000000007;
                    }
                }
            }
        }
        return dp[board.length-1][board[0].length-1];
    }
}



/*for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j].equals("X")){
                    dp[i][j]=Integer.MAX_VALUE;
                }
                if(i==0){
                    if(!board[i][j].equals("X")){
                        dp[i][j]=1;
                    }
                }
            }
        }
        if(board[0][0].equals("X") || board[1][board[0].length-1].equals("X")){
            System.out.println(-1);
        }
        dp[0][0]=1;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(i==0){
                    if(board[i][j]=="." && j>0){
                        dp[i][j]=dp[i][j-1]+1;
                    }
                }
                if(i==1){

                }
            }
        }*/