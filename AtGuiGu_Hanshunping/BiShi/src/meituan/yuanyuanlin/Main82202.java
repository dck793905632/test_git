package meituan.yuanyuanlin;


import java.util.*;

public class Main82202 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=scanner.nextInt();
            arr[i][1]=scanner.nextInt();
        }
        int[][] tmp = new int[n][2];
        for(int i=0;i<n;i++){
            tmp[i][0]=arr[i][0]+2*arr[i][1];
            tmp[i][1]=i+1;
        }
        Arrays.sort(tmp,(arr1,arr2)->(arr2[0]==arr1[0])? arr1[1]-arr2[1]:arr2[0]-arr1[0]);
        int[] res = new int[m];
        for(int i=0;i<m;i++){
            res[i]=tmp[i][1];
        }
        Arrays.sort(res);
        for(int i=0;i<m;i++){
            System.out.print(res[i]+" ");
        }

    }
//    public static int[] maxResult(int[][] mm, int n, int m){
//        int[][] tmp = new int[n][2];
//        for(int i=0;i<n;i++){
//            tmp[i][0]=mm[i][0]+2*mm[i][1];
//            tmp[i][1]=i+1;
//        }
//        Arrays.sort(tmp,(arr1,arr2)->(arr2[0]==arr1[0])? arr1[1]-arr2[1]:arr2[0]-arr1[0]);
//        int[] res = new int[m];
//        for(int i=0;i<m;i++){
//            res[i]=tmp[i][1];
//        }
//        Arrays.sort(res);
//        return res;
//    }
}
