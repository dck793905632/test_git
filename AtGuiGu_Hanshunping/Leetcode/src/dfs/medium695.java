package dfs;

public class medium695 {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    max=Math.max(max,dfs(i,j,grid,m,n));
                }
            }
        }
        return max;
    }
    public int dfs(int i,
                   int j,
                   int[][] grid,
                   int m,
                   int n){
        if(i<0 || i>=m || j<0 || j>=n || grid[i][j]==0){
            return 0;
        }
        int num=1;
        grid[i][j]=0;
        num+=dfs(i+1,j,grid,m,n);
        num+=dfs(i-1,j,grid,m,n);
        num+=dfs(i,j+1,grid,m,n);
        num+=dfs(i,j-1,grid,m,n);
        return num;

    }
}
