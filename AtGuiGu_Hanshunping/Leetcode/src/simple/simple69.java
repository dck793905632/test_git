package simple;

public class simple69 {
    public static void main(String[] args) {
        System.out.println(mySqrt(4));
    }
    public static int mySqrt(int x) {
        if (x==0){
            return 0;
        }
        long left=1;
        long right=x/2;
        while (left<right){
            long mid=(left+right)/2;
            long s1=mid*mid;
            long s2 =(mid+1)*(mid+1);
            if (mid * mid ==x ||(s1<x && s2>x)){
                return (int)mid;
            }else if (mid*mid>x){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return (int)left;

    }
}
