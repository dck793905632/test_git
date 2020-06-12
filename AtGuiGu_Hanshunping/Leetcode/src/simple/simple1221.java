package simple;

import java.util.Stack;

public class simple1221 {
    public static void main(String[] args) {
        String s = "RLRRLLRLRL";
        int i = balancedStringSplit(s);
        System.out.println(i);
    }
    public static int balancedStringSplit(String s) {
        int count=0;
        int res =0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='R'){
                count++;
            }else {
                count--;
            }
            if (count==0){
                res++;
            }
        }
        return res;
    }
    /*public static int balancedStringSplit(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int count=0;
        for (int i = 0; i < chars.length; i++) {
            if (stack.isEmpty()){
                stack.push(chars[i]);
            }else if (judge(chars[i],stack.peek())){
                stack.pop();
            }else {
                stack.push(chars[i]);
            }
            if (stack.isEmpty()){
                count++;
            }
        }
        return count;

    }
    public static boolean judge(char a ,char b){
        if ((a=='R' && b=='L')||(a=='L' && b=='R')){
            return true;
        }else {
            return false;
        }
    }*/
}
