package simple;

public class simple771 {
    public static void main(String[] args) {

    }
    public int numJewelsInStones(String J, String S) {
        char[] charsj = J.toCharArray();
        char[] charss = S.toCharArray();
        int count=0;
        for (int i=0;i<charsj.length;i++){
            for (int j = 0; j < charss.length; j++) {
                if (charsj[i]==charsj[j]){
                    count++;
                }
            }
        }
        return count;
    }
}
