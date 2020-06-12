package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class medium1162 {
    public int maxDistance(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        if(queue.size()==m*n){
            return -1;
        }
        int depth=0;
        while(!queue.isEmpty()){
            depth++;
            int size = queue.size();
            System.out.println(size);
            for(int k=0;k<size;k++){
                int[] tmp = queue.poll();
                int i=tmp[0];
                int j=tmp[1];
                if(i+1<n && grid[i+1][j]!=1){
                    queue.offer(new int[]{i+1,j});
                    grid[i+1][j]=1;
                }
                if(i-1>=0 && grid[i-1][j]!=1){
                    queue.offer(new int[]{i-1,j});
                    grid[i-1][j]=1;
                }
                if(j+1<m && grid[i][j+1]!=1){
                    queue.offer(new int[]{i,j+1});
                    grid[i][j+1]=1;
                }
                if(j-1>=0 && grid[i][j-1]!=1){
                    queue.offer(new int[]{i,j-1});
                    grid[i][j-1]=1;
                }
            }
        }
        return depth-1;
    }
}
