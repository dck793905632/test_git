package bfs;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class simple994 {
    @Test
    public void test(){
        int[][] grid = new int[][]{ {0}};
        System.out.println(orangesRotting(grid));
    }
    public int orangesRotting(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int res=0;
        int count=0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }

            }
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int k=0;k<size;k++){
                int[] arr = queue.poll();
                int i=arr[0];
                int j=arr[1];
                if(i-1>=0){
                    if(grid[i-1][j]==1){
                        queue.offer(new int[]{i-1,j});
                        grid[i-1][j]=2;
                    }
                }
                if(i+1<=row-1){
                    if(grid[i+1][j]==1){
                        queue.offer(new int[]{i+1,j});
                        grid[i+1][j]=2;
                    }
                }
                if(j-1>=0){
                    if(grid[i][j-1]==1){
                        queue.offer(new int[]{i,j-1});
                        grid[i][j-1]=2;
                    }
                }
                if(j+1<=col-1){
                    if(grid[i][j+1]==1){
                        queue.offer(new int[]{i,j+1});
                        grid[i][j+1]=2;
                    }
                }
            }
            if (!queue.isEmpty()){
                res++;
            }
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    return -1;
                }

            }
        }
        return res;
    }
}
