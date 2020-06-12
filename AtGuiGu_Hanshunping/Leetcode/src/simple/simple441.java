package simple;

public class simple441 {
    public static void main(String[] args) {
        System.out.println(arrangeCoins(8));
    }
    public static int arrangeCoins(int n) {
        long left = 0, right = n, mid;
        while (left < right) {
            mid = (left + right + 1) >>> 1;
            System.out.println(mid);
            long t = (1 + mid) * (mid - 1 + 1) / 2;
            if (t > n) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int) left;
    }

    /*public static int arrangeCoins(int n) {
        if (n==1){
            return 1;
        }
        int m =n;
        for (int i=1;i<=n;i++){

            if (m<i){
                return i-1;
            }
            m=m-i;
        }
        return 0;
    }*/
}
