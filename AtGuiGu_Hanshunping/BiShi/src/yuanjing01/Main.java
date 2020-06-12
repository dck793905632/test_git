package yuanjing01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n=scanner.nextInt();
            int[] xuehao = new int[n];
            int[] score = new int[n];
            for(int i =0;i<n;i++){
                xuehao[i]=scanner.nextInt();
                score[i]=scanner.nextInt();
            }
            for(int i=0;i<n;i++){
                for(int j =0;j<n-1;j++){
                    if(score[j]>score[j+1]){
                        int tmp =score[j+1];
                        score[j+1]=score[j];
                        score[j]=tmp;
                        tmp=xuehao[j];
                        xuehao[j]=xuehao[j+1];
                        xuehao[j+1]=tmp;
                    }else if(score[j]==score[j+1]){
                        if(xuehao[j]>xuehao[j+1]){
                            int tmp=xuehao[j];
                            xuehao[j]=xuehao[j+1];
                            xuehao[j+1]=tmp;
                        }
                    }
                }
            }
            for(int i=0;i<n;i++){
                System.out.println(xuehao[i]+" "+score[i]);
            }
        }
        scanner.close();
    }
}
