package simple;

import java.util.Arrays;

public class simple167 {
    public static void main(String[] args) {
        int[] arr ={2, 3, 7,11, 15};
        int[] ints = twoSum(arr, 9);
        System.out.println(Arrays.toString(ints));
    }
    public static int[] twoSum(int[] numbers, int target) {
        int i=0;
        int j=numbers.length-1;
        while (i<j){
            if (numbers[i]+numbers[j]==target){
                return new int[]{i+1,j+1};
            }
            if (numbers[i]+numbers[j]>target){
                j--;
            }
            if (numbers[i]+numbers[j]<target){
                i++;
            }
        }
        return null;
    }
    /*public static int[] twoSum(int[] numbers, int target) {
        int i,j;
        for (i=0;i<numbers.length-1;i++){
            for (j=i+1;j<numbers.length;j++){
                if (numbers[i]+numbers[j]==target){
                    return new int[]{i+1,j+1};
                }
            }
        }
        return null;
    }*/
}
