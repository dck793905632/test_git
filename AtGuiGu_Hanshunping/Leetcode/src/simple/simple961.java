package simple;

public class simple961 {
    public static void main(String[] args) {

    }
    public int repeatedNTimes(int[] A) {
        int N = A.length/2;
        int count=0;
        int i,j;
        for ( i=0;i<A.length;i++){
            for ( j = 0; j < A.length; j++) {
                if (A[i]==A[j]){
                    count++;
                }
            }
            if (N==count){
                return A[i];
            }else {
                count=0;
            }
        }
        return -1;
    }
}
