package simple;

public class simple709 {
    public static void main(String[] args) {
        String str ="al&phaBET";
        System.out.println(toLowerCase(str));
    }
    public static String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]>='A'&&chars[i]<='Z'){
                char c = chars[i];
                c+=32;
                chars[i]=c;
            }
        }
        return String.valueOf(chars);
    }
}
