package simple;

import org.junit.Test;

public class simple852 {
    @Test
    public void test(){
        int n = peakIndexInMountainArray(new int[]{0,1,2,3,4,5,6,7,6,5,4,3});
        System.out.println(n);
    }
    public int peakIndexInMountainArray(int[] A) {
        int left =0;
        int right = A.length-1;
        while (left<right){
            int mid=left+(right-left)/2;
            if (A[mid]<A[mid+1]){
                left=mid+1;
            }else {
                right=mid;
            }
        }
        return left;
    }
    /*public int peakIndexInMountainArray(int[] A) {
        for (int i=0;i<A.length-1;i++){
            if (A[i]<A[i+1]&&A[i+1]>A[i+2]){
                return i+1;
            }
        }
        return -1;
    }*/
}
