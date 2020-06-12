package simple;

public class simple557 {
    public static void main(String[] args) {
        String s= "Let's take LeetCode contest";
        String s1 = reverseWords(s);
        System.out.println(s1);
    }
    public static String reverseWords(String s) {
        String[] s1 = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s1.length; i++) {
            builder.append(new StringBuilder(s1[i]).reverse().toString());
            builder.append(" ");
        }
        return builder.toString().trim();
    }
    /*public static String reverseWords(String s) {
        String[] split = s.split(" ");
        String str ="";
        for (int i = 0; i < split.length; i++) {
            String resver = reverse(split[i]);
            str=str+resver+" ";
        }
        return str.trim();
    }
    public static String reverse(String s){
        char[] chars = s.toCharArray();
        char temp;
        for (int i = 0; i < chars.length/2; i++) {
            temp=chars[i];
            chars[i]=chars[chars.length-1-i];
            chars[chars.length-1-i]=temp;
        }
        return String.valueOf(chars);
    }*/
}
