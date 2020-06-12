package simple;

public class simple456 {
    public static void main(String[] args) {
        String str = "abaababaab";
        System.out.println(repeatedSubstringPattern(str));

    }


    public static boolean repeatedSubstringPattern(String s) {
        char[] chars = s.toCharArray();
        for (int i = 1; i <= chars.length/2; i++) {
            if (chars.length%i==0 && judge(s,i,chars.length/i)){
                return true;
            }
        }
        return false;
    }
    public static boolean judge(String s,int i,int j){

        StringBuilder sb = new StringBuilder();
        for (int k=0;k<j;k++){
            sb.append(s.substring(0,i));
        }
        System.out.println(s);
        return s.equals(sb.toString());
    }

    /*public static boolean repeatedSubstringPattern(String s) {
        String str = s+s;
        return str.substring(1,str.length()-1).contains(s);
    }*/
}
