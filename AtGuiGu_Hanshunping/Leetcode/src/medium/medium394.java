package medium;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Stack;

public class medium394 {
    @Test
    public void test(){
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.toString());
        System.out.println(sb);
        stack.push(sb.toString());
        String pop = stack.pop();
        System.out.println(pop);
        System.out.println(stack.size());

    }
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack_Int  = new Stack<>();
        Stack<String> stack_Str = new Stack<>();
        int m=0;
        for(Character c : s.toCharArray()){
            if(c=='['){
                stack_Int.push(m);
                stack_Str.push(sb.toString());
                m=0;
                sb=new StringBuilder();
            }else if(c==']'){
                int n = stack_Int.pop();
                StringBuilder tmp = new StringBuilder();
                for(int i=0;i<n;i++){
                    tmp.append(sb);
                }
                sb = new StringBuilder(stack_Str.pop()+tmp.toString());
            }else if(c>='0' &&c<='9'){
                m=m*10+Integer.parseInt(c+"");
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
