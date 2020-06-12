package zijietiaodong;

public class UnrepeatStr {
    public static void main(String[] args) {

    }
    public static int index(String s,char[] c){
        char[] chars = s.toCharArray();
        int i=0;
        int count=0;
        while (i<chars.length){
            if (isC(chars[i],c)){
                i++;
                count++;
            }else {
                i++;
                count=0;
            }
        }
        return 0;
    }
    public static boolean isC(char ch,char[] c){
        for (int i=0;i<c.length;i++){
            if (ch==c[i]){
                return true;
            }
        }
        return false;
    }
}
