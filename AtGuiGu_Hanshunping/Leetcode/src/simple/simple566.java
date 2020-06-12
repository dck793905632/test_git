package simple;

public class simple566 {
    public static void main(String[] args) {

    }
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (r*c != nums.length*nums[0].length){
            return nums;
        }
        int[][] newArr = new int[r][c];
        int row=0;
        int col =0;
        for (int i=0;i<nums.length;i++){
            for (int j = 0; j < nums[0].length; j++) {
                newArr[row][col%c]=nums[i][j];
                col++;
                if (col%c==0){
                    row++;
                }
            }
        }
        return newArr;
    }
}
