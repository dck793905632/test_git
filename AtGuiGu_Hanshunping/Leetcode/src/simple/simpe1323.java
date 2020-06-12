package simple;

public class simpe1323 {
    public int maximum69Number (int num) {
        String str =String.valueOf(num);
        String s = str.replaceFirst("6", "9");
        return Integer.valueOf(s);
    }
}
