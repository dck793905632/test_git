package simple;

import java.util.Arrays;

public class simple88 {
    public static void main(String[] args) {

        merge(new int[]{2,2,3,0,0,0,0,0},3,new int[]{1,1,1,5,6},5);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int k=m+n-1;
        int i=m-1;
        int j = n-1;
        while (i>=0 &&j>=0){
            if (nums1[i]<=nums2[j]){
                nums1[k]=nums2[j];
                k--;
                j--;
            }else {
                nums1[k]=nums1[i];
                i--;
                k--;
            }
        }

        for (int l = 0; l < j + 1; l++) {
            nums1[l]=nums2[l];
        }

    }

    /*public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i=0;i<n;i++){
            nums1[m+i]=nums2[i];
        }
        int temp=0;
        for (int i = 0; i < m + n - 1; i++) {
            for (int j = i+1; j <m+n ; j++) {
                if (nums1[i]>nums1[j]){
                    temp=nums1[i];
                    nums1[i]=nums1[j];
                    nums1[j]=temp;
                }
            }
        }

    }*/
}
