package simple;

public class simple657 {
    public static void main(String[] args) {

    }
    public boolean judgeCircle(String moves) {
        char[] chars = moves.toCharArray();
        int l=0;
        int r=0;
        int u=0;
        int d=0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]=='U'){
                u++;
            }
            if (chars[i]=='D'){
                d++;
            }
            if (chars[i]=='R'){
                r++;
            }
            if (chars[i]=='L'){
                l++;
            }
        }
        if (r==l&&u==d){
            return true;
        }else {
            return false;
        }
    }
}
