package simple;

public class simple58 {
    public static void main(String[] args) {
        String s = " hell woe ";
        int i = lengthOfLastWord(s);
        System.out.println(i);

    }
    public static int lengthOfLastWord(String s) {
        int len=0;
        for (int i = s.length()-1; i >=0 ; i--) {
            if (s.charAt(i)!=' '){
                len++;
            }else {
                if (len>0){
                    return len;
                }
            }
        }
        return len;
    }

    /*public static int lengthOfLastWord(String s) {
        String trim = s.trim();
        String[] s1 = trim.split(" ");
        int len = s1.length;
        return s1[len-1].length();
    }*/
}
