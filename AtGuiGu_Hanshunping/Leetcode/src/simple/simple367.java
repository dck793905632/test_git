package simple;

public class simple367 {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(808201));
    }
    public static boolean isPerfectSquare(int num) {
        if(num==1){
            return true;
        }
        long left=1;
        long right=num/2;
        while(left<=right){
            long mid=(left+right)/2;
            long seq =mid*mid;
            if(seq==num){
                return true;
            }else if(seq<num){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return false;
    }
}
