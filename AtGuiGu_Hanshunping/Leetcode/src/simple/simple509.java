package simple;

public class simple509 {
    public static void main(String[] args) {

    }
    public static int fib(int N) {
        if(N==0){
            return 0;
        }
        if(N==1){
            return 1;
        }

        return fib(N-1)+fib(N-2);


    }
}
