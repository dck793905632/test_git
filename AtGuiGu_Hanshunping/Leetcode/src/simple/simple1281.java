package simple;

public class simple1281 {
    public static void main(String[] args) {

    }
    public int subtractProductAndSum(int n) {
        int sum=0;
        int mul=1;
        while (n>=1){
            sum+=n%10;
            mul*=n%10;
            n=(n-n%10)/10;
        }
        return mul-sum;
    }
}
