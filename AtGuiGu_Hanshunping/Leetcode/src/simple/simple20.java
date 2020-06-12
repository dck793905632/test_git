package simple;

import java.util.Stack;

public class simple20 {
    public static void main(String[] args) {
        String s = "()[]{}";
        boolean valid = isValid(s);
        System.out.println(valid);
    }
    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i=0;i<chars.length;i++){
            if (stack.isEmpty()){
                stack.push(chars[i]);
            }else if (compare(stack.peek(),chars[i])){
                stack.pop();
            }else {
                stack.push(chars[i]);
            }
        }
        return stack.size()==0;

    }
    public static boolean compare(char a,char b){
        if ((a=='(' && b==')')||(a=='{' && b=='}') || (a=='[' && b==']')){
            return true;
        }else {
            return false;
        }
    }
}
