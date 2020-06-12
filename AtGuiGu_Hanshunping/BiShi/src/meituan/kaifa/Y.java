package meituan.kaifa;

import java.util.Scanner;

public class Y {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            int y = scanner.nextInt();
            arr[i]=x;
        }
        int majority = majority(arr,x);
        System.out.println(majority);


    }
    public static int majority(int[] nums,int x){
        int res =0,k=nums.length>>1;
        for(int j=0;j<32;j++){
            int count=0;
            for(int num : nums){
                count+=num>>j & 1;
                if(count>k){
                    res+=1<<j;
                    break;
                }
            }
        }
        return res;
    }
}
