package simple;

public class simple905 {
    public static void main(String[] args) {

    }
    public int[] sortArrayByParity(int[] A) {

        int temp=0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i+1; j < A.length; j++) {

                if (A[i]%2!=0&&A[j]%2==0){
                    temp=A[j];
                    A[j]=A[i];
                    A[i]=temp;
                }
            }
        }
        return A;
    }
}
