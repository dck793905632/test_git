package yuanjing01;

import java.util.Scanner;

public class Main1 {
    public static String calculateStringDistance(String expressionA,String expressionB){
        int[][] dp = new int[expressionA.length()+1][expressionB.length()+1];
        for(int i=0;i<=expressionA.length();i++){
            dp[i][0]=i;
        }
        for(int i=0;i<=expressionB.length();i++){
            dp[0][i]=i;
        }
        int temp = 0;
        for(int i=1;i<=expressionA.length();i++){
            for(int j=1;j<=expressionB.length();j++){
                if(expressionA.charAt(i-1)==expressionB.charAt(j-1)){
                    temp=0;
                }else {
                    temp=1;
                }
                dp[i][j]=Math.min(Math.min(dp[i-1][j-1]+temp,dp[i][j-1]+1),dp[i-1][j]+1);
            }
        }
        StringBuilder sb = new StringBuilder();
        dp[expressionA.length()][expressionB.length()]+=1;
        sb.append(1+"/"+dp[expressionA.length()][expressionB.length()]);
        return sb.toString();

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str1 =scanner.next();
            String str2 = scanner.next();
            System.out.println(calculateStringDistance(str1,str2));
        }
    }
}
