package com.atguigu.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {

        //String sufferExpression="4 5 * 8 - 6 +";


        String expression="1+((2+3)*4)-5";
        List<String> list = toInfixExpressionList(expression);
        List<String> list1 = parseSuffixExpression(list);
        System.out.println(list1);
//        //1将表达式放入ArrayList中
//        //2配合一个栈工作
//        List<String> listString = getListString(sufferExpression);
//        System.out.println(listString);
//        int res = calculate(listString);
//        System.out.println(res);

    }

    //将中缀表达式转为list
    public static List<String> toInfixExpressionList(String expression){
        int i=0;//定义指针遍历中缀表达式
        char c;//接收每一个字符
        String str;//对多位数的拼接
        List<String> ls = new ArrayList<>();
        do {
            //如果c是一个非数字，则加入list
            if ((c=expression.charAt(i))<48 || (c=expression.charAt(i))>57){
                ls.add(c+"");
                i++;
            }else {
                //如果是一个数字
                str="";
                while (i<expression.length() &&(c=expression.charAt(i))>=48 && (c=expression.charAt(i))<=57){
                    str+=c;
                    i++;
                }
                ls.add(str);
            }
        }while (i<expression.length());
        return ls;
    }
    //中缀转后缀
    public static List<String> parseSuffixExpression(List<String> ls){
        //定义两个栈（一个就行，另一个用list代替）
        Stack<String> s1 = new Stack<>();
        List<String> s2 = new ArrayList<>();

        //遍历ls
        for (String item : ls){
            //如果是数，入s2
            if (item.matches("\\d+")){
                s2.add(item);
            }else if (item.equals("(")){
                s1.push(item);
            }else if (item.equals(")")){
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();
            }else {
                while (s1.size()!=0 && Operation.getValue(s1.peek())>=Operation.getValue(item)){
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
        while (s1.size()!=0){
            s2.add(s1.pop());
        }
        return s2;
    }
    public static List<String> getListString(String sufferExpression){
        String[] s = sufferExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String str : s){
            list.add(str);
        }
        return list;
    }
    //判断是数字，入栈，运算符，从数栈取出两个数运算，再将运算结果存入数栈
    public static int calculate(List<String> list){
        int res =0;
        Stack<Integer> stack = new Stack<>();
        for (String item : list){
            if (item.matches("\\d+")){
                //如果是数字，入数栈
                stack.push(Integer.parseInt(item));
            }else {
                //符号
                int num2 = stack.pop();
                int num1 = stack.pop();
                if (item.equals("+")){
                    res=num1+num2;
                }else if(item.equals("-")){
                    res=num1-num2;
                }else if (item.equals("*")){
                    res=num1*num2;
                }else if (item.equals("/")){
                    res=num1/num2;
                }else {
                    throw new RuntimeException("运算符有误");
                }
                stack.push(res);
            }

        }
        return stack.pop();
    }

}
class Operation{
    private static int ADD=1;
    private static int SUB=1;
    private static int MUL=2;
    private static int DIV=2;

    public static int getValue(String operation){
        int res=0;
        switch(operation){
            case "+":
                res=ADD;
                break;
            case "-":
                res=SUB;
                break;
            case "*":
                res=MUL;
                break;
            case "/":
                res=DIV;
                break;
            default:
                break;
        }
        return res;

    }
}