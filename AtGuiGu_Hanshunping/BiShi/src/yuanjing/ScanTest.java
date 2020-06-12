package yuanjing;

import java.util.Arrays;
import java.util.Scanner;

public class ScanTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //String s = scanner.nextLine();
        //String[] s1 = s.split(" ");
        int[] arr = new int[5];
        /*for(int i=0;i<5;i++){
            arr[i]=scanner.nextInt();
        }
        System.out.println(Arrays.toString(arr));*/

        int[][] grid = new int[3][3];
        for(int i=0;i<3;i++){
            for (int j = 0; j < 3; j++) {
                grid[i][j]=scanner.nextInt();
            }
        }

        for(int i=0;i<3;i++){
            for (int j = 0; j < 3; j++) {
                System.out.println(grid[i][j] + " ");
            }
            System.out.println(

            );
        }


    }
}
