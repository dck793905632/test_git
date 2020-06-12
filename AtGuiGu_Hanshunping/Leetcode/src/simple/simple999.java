package simple;

public class simple999 {
    public static void main(String[] args) {
        char[][] board = {{'.','.','.','.','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'.','.','.','R','.','.','.','p'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.'}
        };
        System.out.println(numRookCaptures(board));
    }
    public static int numRookCaptures(char[][] board) {
        int row=0,col=0;
        for (int i=0; i<board.length ; i++) {
            for (int j=0;j<board[0].length;j++){
                  if (board[i][j]=='R'){
                      row=i;
                      col=j;
                      break;
                  }
            }
        }
        System.out.println(row+" "+col);
        int count=0;
        for (int i=col-1;i>=0;i--){
            if (board[row][i]=='B'){
                break;
            }
            if (board[row][i]=='p'){
                count++;
                break;
            }
        }
        for (int i=col+1;i<8;i++){
            if (board[row][i]=='B'){
                break;
            }
            if (board[row][i]=='p'){
                count++;
                break;
            }
        }
        for (int i=row-1;i>=0;i--){
            if (board[i][col]=='B'){
                break;
            }
            if (board[i][col]=='p'){
                count++;
                break;
            }
        }
        for (int i=row+1;i<8;i++){
            if (board[i][col]=='B'){
                break;
            }
            if (board[i][col]=='p'){
                count++;
                break;
            }
        }
        return count;
    }
}
