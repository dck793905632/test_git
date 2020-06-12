package baidu;


import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[] arr = new int[N];
        String str="";
        for(int i=0;i<N;i++){
            arr[i]=scanner.nextInt();
            str+=arr[i];
        }
        int c=0;
        String[] split = str.split("1");
        for(int i=0;i<split.length;i++){
            if (!split[i].equals("")){
                c++;
            }
        }
        int cx=0;
        int cy=0;
        int c1=0;
        int c2=0;
        int i=0;


        for(int k=0;k<N;k++){
            if(arr[k]==0){
                cx++;
            }
            if(arr[k]==1){
                cy++;
            }
        }
        int sum=0;
        sum+=cx*x;
        int sum1=0;
        sum1+=c*y;
        System.out.println(Math.min(sum,sum1));


    }
}
