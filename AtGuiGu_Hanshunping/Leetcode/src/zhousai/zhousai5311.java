package zhousai;

import org.junit.Test;

public class zhousai5311 {
    @Test
    public void test(){
        int[] arr = new int[]{11,13,17,23,29,31,7,5,2,3};
        System.out.println(angleClock(3,15));
    }

    public double angleClock(int hour, int minutes) {
        double jiajiao = Math.abs(minutes * 6 - (hour * 30 + 30.00 * minutes / 60));
        jiajiao = jiajiao % 360;
        if (jiajiao>180){
            return 360-jiajiao;
        }else {
            return jiajiao;
        }
    }
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count=0;
        int i=0;
        int j=k;
        int sum=0;
        int l=0;
        while (i<arr.length && j<arr.length+1){
            while (i<j){
                sum+=arr[i];
                i++;
            }
            if (sum/k>=threshold){
                count++;
            }
            sum=0;
            j+=1;
            i=j-k;
        }
        return count;
    }
    public int numberOfSteps (int num) {
        int count=0;
        while(num!=0){
            if (num%2==0){
                num=num/2;
                count++;
            }
            if (num%2!=0){
                num=num-1;
                count++;
            }
        }
        return count;
    }
}
