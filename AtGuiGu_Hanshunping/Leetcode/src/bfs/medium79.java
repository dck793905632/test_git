package bfs;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class medium79 {

    @Test
    public void test(){
        char[][] board = new char[][]{{'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(exist(board,word));
    }

    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        int m=board.length;
        int n =board[0].length;
        boolean[][] isPass= new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dfs(i,j,0,board,chars,isPass)){
                    return true;
                }
            }
        }
        return false;
    }
    int[][] dic = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public boolean dfs(int i,
                       int j,
                       int start,
                       char[][] board,
                       char[] chars,
                       boolean[][] isPass){
        if(start==chars.length-1){
            return chars[start]==board[i][j];
        }

        if(chars[start]==board[i][j]){
            isPass[i][j]=true;
            for(int k=0;k<4;k++){
                int newX = i+dic[k][0];
                int newY = j+dic[k][1];
                if(isRange(newX,newY,board.length,board[0].length) && !isPass[newX][newY]){
                    if(dfs(newX,newY,start+1,board,chars,isPass)){
                        return true;
                    }
                }
            }
            isPass[i][j]=false;
        }
        return false;
    }
    public boolean isRange(int x,int y,int m,int n){
        return x>=0 && x<m && y>=0 && y<n;
    }
}
