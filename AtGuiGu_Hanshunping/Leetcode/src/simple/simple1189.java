package simple;

public class simple1189 {
    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("loonbalxballpoon"));
    }
    public static int maxNumberOfBalloons(String text) {
        char[] chars = text.toCharArray();
        int b=0;
        int a=0;
        int l=0;
        int o=0;
        int n=0;
        for (int i=0;i<chars.length;i++){
            if (chars[i]=='b'){
                b++;
            }
            if (chars[i]=='a'){
                a++;
            }
            if (chars[i]=='l'){
                l++;
            }
            if (chars[i]=='o'){
                o++;
            }
            if (chars[i]=='n'){
                n++;
            }
        }
        o=o/2;
        l=l/2;
        System.out.println(n);
        int[] arr = {b,a,l,o,n};
        int min=arr[0];
        for (int i=1;i<arr.length;i++){
            if (arr[i]<min){
                min=arr[i];
            }
        }
        return min;
    }
}
