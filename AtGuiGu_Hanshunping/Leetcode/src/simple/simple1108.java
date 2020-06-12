package simple;

public class simple1108 {
    public static void main(String[] args) {
        String str ="1.1.1.1";
        System.out.println(defangIPaddr(str));
    }
    public static String defangIPaddr(String address) {
        char[] chars = address.toCharArray();
        String str ="";
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='.'){
                str+="[.]";
            }else {
                str+=chars[i];
            }
        }
        return str;
    }
    /*public String defangIPaddr(String address) {
        return address.replaceAll("\\.","[.]");
    }*/
}
