package simple;

public class simple551 {
    public static void main(String[] args) {
        String s = "LLPPLL";
        System.out.println(checkRecord(s));
    }
    public static boolean checkRecord(String s) {
        int a=0;
        int l=0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='A'){
                l=0;
                a++;
                if (a>1){
                    return false;
                }
            }else if (s.charAt(i)=='L'){
                l++;
                if (l>2){
                    return false;
                }
            }else {
                l=0;
            }
        }
        return true;
    }
    /*public static boolean checkRecord(String s) {
        int a=0;
        int l=0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='A'){
                a++;
            }
        }
        for (int i = 0; i < s.length() - 2; i++) {
            if (s.charAt(i)=='L'&&s.charAt(i+1)=='L'&&s.charAt(i+2)=='L'){
                l++;
            }
        }
        if ((a<=1&&l<1)){
            return true;
        }else {
            return false;
        }
    }*/
}
