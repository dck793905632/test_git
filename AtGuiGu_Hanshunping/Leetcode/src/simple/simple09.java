package simple;

public class simple09 {
    public static void main(String[] args) {
        int a =-121;
        boolean flag = isPalindrome(a);
        System.out.println(flag);
    }
    public static boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        StringBuilder stringBuilder = new StringBuilder(str);
        String str1 = stringBuilder.toString();
        StringBuilder stringBuilder1 = stringBuilder.reverse();
        String str2 = stringBuilder1.toString();
        return str1.equals(str2);

    }
    /*public static boolean isPalindrome(int x) {
        int x1 = x;
        int ret = 0;
        while (x!=0){
            int temp =ret*10 + x%10;
            ret=temp;
            x=x/10;
        }
        System.out.println(ret);
        if (ret==x1&&x1>=0){
            return true;
        }else {
            return false;
        }
    }*/
}
