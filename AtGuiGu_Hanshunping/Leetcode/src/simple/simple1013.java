package simple;

public class simple1013 {
    public static void main(String[] args) {
        //int[] A={3,3,6,5,-2,2,5,1,-9,4};
        int[] A={1,-1,-1,1};
        //int[] A={18,12,-18,18,-19,-1,10,10};
        //System.out.println(canThreePartsEqualSum(A));
    }
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        if (sum % 3 != 0) {
            return false;
        }
        int value = sum/3;
        int curSum=0;
        int count=0;
        for(int i=0;i<A.length;i++){
            curSum+=A[i];
            if(curSum==value){
                curSum=0;
                count++;
            }
        }
        return count==3 ||(count>3 &&sum==0);
    }
    /*public static boolean canThreePartsEqualSum(int[] A) {
        int sum=0;
        for(int i=0;i<A.length;i++){
            sum+=A[i];
        }
        if(sum%3!=0){
            return false;
        }
        int sum1=0;
        int start=0;
        int end=0;
        for (int i=0;i<A.length;i++){
            sum1+=A[i];
            if (sum1==sum/3){
                start=i+1;
                break;
            }
        }
        int sum2=0;
        for (int i=A.length-1;i>=0;i--){
            sum2+=A[i];
            if (sum2==sum/3){
                end=i-1;
                break;
            }
        }
        int sum3=0;
        for (int i = start; i <=end ; i++) {
            sum3+=A[i];
        }
        if (sum3==sum/3){
            return true;
        }else {
            return false;
        }

    }*/
}
