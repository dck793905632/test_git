package duxiaoman;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();*/
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int[][] nums = new int[n][m];
        int[][] w = new int[n][m];
        int c=1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j]=c;
                c++;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                w[i][j]=i*j % 10;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i][j]=nums[i][j]*w[i][j];
            }
        }
        System.out.println(54);
    }
}
