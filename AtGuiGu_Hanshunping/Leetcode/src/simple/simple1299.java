package simple;

public class simple1299 {
    public static void main(String[] args) {

    }
    public static int[] replaceElements(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            int max =Integer.MIN_VALUE;
            for (int j = i+1; j < arr.length; j++) {
                if (max<arr[j]){
                    max=arr[j];
                }
            }
            arr[i]=max;
            if (i==arr.length-1){
                arr[i]=-1;
            }
        }
        return arr;
    }
}
