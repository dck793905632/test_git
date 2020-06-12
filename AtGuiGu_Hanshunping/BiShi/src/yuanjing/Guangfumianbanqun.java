package yuanjing;

public class Guangfumianbanqun {
    //最大光伏面板群：dfs遍历，遍历过的点清0：



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

    /*
    *
    *

#include <iostream>
#include <vector>
#include <cmath>
#include <string>
#include <sstream>

using namespace std;

int dfs(int i,int j,vector<vector<int> > &grid )
{
    int m=grid.size();
    int n=grid[0].size();
    int area=1;
    grid[i][j]=0;
    if(i-1>=0&&grid[i-1][j]==1)area+=dfs(i-1,j,grid);
    if(i+1<m&&grid[i+1][j]==1)area+=dfs(i+1,j,grid);
    if(j-1>=0&&grid[i][j-1]==1)area+=dfs(i,j-1,grid);
    if(j+1<n&&grid[i][j+1]==1)area+=dfs(i,j+1,grid);
    return area;

}

int maxArea(vector<vector<int> > &grid)
{
    int m=grid.size();
    int n=grid[0].size();
    if(m==0)
        return 0;
    int ans=0;
    for(int i=0;i<m;++i)
    {
        for(int j=0;j<n;++j)
        {
            if(grid[i][j]==1)
            {
                ans=max(ans,dfs(i,j,grid));
            }
        }
    }
    return ans;
}

int main()
{
    int n,m;
    char c;
    cin>>n>>c>>m;
    vector<vector<int> >grid;
    for(int i=0;i<n;++i)
    {
        string str;
        int temp;
        char c;
        cin>>str;
        vector<int>arr;
        str+=',';
        istringstream is(str);
        while(is>>temp>>c)
        {
            arr.emplace_back(temp);
        }
        grid.emplace_back(arr);
    }
    cout<<maxArea(grid)<<endl;


    return 0;
}
    * */

}
