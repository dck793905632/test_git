package simple;

public class simple985 {
    public static void main(String[] args) {

    }
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {

        int val=0;
        int index=0;
        int sum=0;
        int[] newArr = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            val=queries[i][0];
            index=queries[i][1];
            A[index]+=val;
            for (int j=0;j<A.length;j++){
                if (A[j]%2==0){
                    sum+=A[j];
                }
            }
            newArr[i]=sum;
            sum=0;
        }
        return newArr;
    }
}
