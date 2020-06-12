package simple;

public class simple867 {
    public static void main(String[] args) {

    }
    public int[][] transpose(int[][] A) {

        int row=A[0].length;
        int col=A.length;
        int[][] arr = new int[row][col];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                arr[i][j]=A[j][i];
            }
        }
        return arr;
    }
}
