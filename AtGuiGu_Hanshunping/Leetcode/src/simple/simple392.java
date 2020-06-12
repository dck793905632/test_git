package simple;

public class simple392 {
    public static void main(String[] args) {
        String s ="twn";
        String t="xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxtxxxxxxxxxxxxxxxxxxxxwxxxxxxxxxxxxxxxxxxxxxxxxxx";
        System.out.println(isSubsequence(s,t));
    }
    public static boolean isSubsequence(String s, String t) {
        int i = -1;
        for(char c : s.toCharArray()){
            i =  t.indexOf(c,i+1);
            System.out.println(i);
            if(i == -1){
                return  false;
            }
        }
        return true;
    }
    /*public static boolean isSubsequence(String s, String t) {
        char[] chars1 = s.toCharArray();
        String str = t;
        int count=0;
        for (int i = 0; i < chars1.length; i++) {
            int index=0;
            char[] chars2 = str.toCharArray();
            while (index<chars2.length){
                if (chars1[i]==chars2[index]){
                    str=str.substring(index+1,str.length());
                    count++;
                    break;
                }else {
                    index++;
                }
            }
        }
        if (count==chars1.length){
            return true;
        }else {
            return false;
        }
    }*/


}
