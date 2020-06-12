package simple;

public class simple463 {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n =grid[0].length;
        int sum=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int r=4;
                    if(i-1>=0 && grid[i-1][j]==1){
                        r--;
                    }
                    if(i+1<m && grid[i+1][j]==1){
                        r--;
                    }
                    if(j-1>=0 && grid[i][j-1]==1){
                        r--;
                    }
                    if(j+1<n && grid[i][j+1]==1){
                        r--;
                    }
                    sum+=r;
                }
            }
        }
        return sum;
    }
}
