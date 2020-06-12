package meituan.cekai;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i]=scanner.nextInt();
            }
            System.out.println(lengthOfLIS(arr));
        }
    }
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n==0){
            return 0;
        }
        int[] dp = new int[n];
        int res =0;
        for(int j=0;j<n;j++){
            dp[j]=1;
            for(int i=0;i<j;i++){
                if(nums[i]<nums[j] && i<j){
                    dp[j]=Math.max(dp[i]+1,dp[j]);
                }
            }
            res = Math.max(res,dp[j]);
        }
        return res;
    }
}
