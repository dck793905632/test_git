package dfs;

public class medium130 {
    public void solve(char[][] board) {
        int n = board.length;
        if(n==0){
            return;
        }
        int m = board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                boolean edge = i==0 || j==0 || i==n-1 || j==m-1;
                if(edge){
                    dfs(board,i,j,n,m);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }
    }
    public void dfs(char[][] board,int i,int j,int n,int m){
        if(i<0 || j<0 || i==n || j==m || board[i][j]=='X' || board[i][j]=='#'){
            return;
        }
        board[i][j]='#';
        dfs(board,i+1,j,n,m);
        dfs(board,i-1,j,n,m);
        dfs(board,i,j+1,n,m);
        dfs(board,i,j-1,n,m);
    }

}
