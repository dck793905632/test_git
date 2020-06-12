package dfs;

import org.junit.Test;

public class medium1254 {
    @Test
    public void test(){
        int[][] grid = new int[][]{ {1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},
                {1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
        System.out.println(closedIsland(grid));
    }
    boolean isIsland;
    public int closedIsland(int[][] grid) {
        if(grid==null||grid.length==2||grid[0].length==2){
            return 0;
        }
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    //当前是一块陆地 关联周围所有的区域 设为1
                    isIsland = true;
                    dfs(grid,i,j);
                    if(isIsland){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public void dfs(int[][] grid,int i,int j){
        grid[i][j]=1;
        if(i==0||i==grid.length-1 ||j==0 ||j==grid[0].length-1){
            isIsland = false;
        }
        if(i-1>=0 &&grid[i-1][j]==0){
            dfs(grid,i-1,j);
        }
        if(j-1>=0 && grid[i][j-1]==0){
            dfs(grid,i,j-1);
        }
        if(i+1<grid.length && grid[i+1][j]==0){
            dfs(grid,i+1,j);
        }
        if(j+1<grid[0].length && grid[i][j+1]==0){
            dfs(grid,i,j+1);
        }
    }

}
