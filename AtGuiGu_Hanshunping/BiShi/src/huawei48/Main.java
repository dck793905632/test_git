package huawei48;

public class Main {
    public static void main(String[] args) {
        System.out.println(quickMi(2,5));
    }
    public static Long quickMi(long a,long b){
        long result = 1;
        long n =a;
        long power = b;
        while(power>0){
            if(power%2==1){
                result=result*n%1000000007;
            }
            power=power/2;
            n=(n*n)%1000000007;
        }
        return result;

    }
}
