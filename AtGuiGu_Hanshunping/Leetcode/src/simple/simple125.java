package simple;

public class simple125 {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean palindrome = isPalindrome(s);
        System.out.println(palindrome);
    }

    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0)
            return true;
        String str = s.replaceAll("[^0-9a-zA-Z]", "").toLowerCase();
        int len = str.length();
        for (int i = 0; i < len/2; i++) {
            if(str.charAt(i)!=str.charAt(len-1-i))
                return false;
        }
        return true;
    }
    /*public static boolean isPalindrome(String s) {

        String str ="";
        for (int i =0;i<s.length();i++){
            if ((s.charAt(i)>='a'&&s.charAt(i)<='z')
                    ||(s.charAt(i)>='0'&&s.charAt(i)<='9')){
                str=str+s.charAt(i);
            }else if (s.charAt(i)>='A'&&s.charAt(i)<='Z'){
                char c = s.charAt(i);
                c+=32;
                str+=c;
            }
        }
        for (int i = 0; i <str.length()/2; i++) {
            if (str.charAt(i)!=str.charAt(str.length()-1-i)){
                return false;
            }
        }
        return true;
    }*/
}
