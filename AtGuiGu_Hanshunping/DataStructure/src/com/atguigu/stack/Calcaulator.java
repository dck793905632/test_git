package com.atguigu.stack;

public class Calcaulator {
    public static void main(String[] args) {
        String experssion = "30+2*6";

        //创建两个栈，一个符号栈，一个数字栈
        ArrayStack2 numStack= new ArrayStack2(10);
        ArrayStack2 operStack= new ArrayStack2(10);
        //定义变量
        int index=0;
        int num1=0;
        int num2=0;
        int oper=0;
        int res =0;
        char ch =' ';
        String keepNum="";
        while (true){
            //依次得到每个字符
            ch=experssion.substring(index,index+1).charAt(0);
            //判断ch是什么
            if (operStack.isOper(ch)){
                //判断栈是否为空
                if (!operStack.isEmpty()){
                    //如果符号栈有操作符，就进行比较，如果当前操作符优先级小于栈中操作符优先级，需要从
                    //数栈取出两个数字
                    //再从符号栈中pop出一个符号，进行运算，然后将当前符号入栈
                    if (operStack.priority(ch)<operStack.priority(operStack.peek())){
                        num1=numStack.pop();
                        num2=numStack.pop();
                        oper=operStack.pop();
                        res=numStack.cal(num1,num2,oper);
                        //数字入数栈
                        numStack.push(res);
                        //操作符入符号栈
                        operStack.push(ch);
                    }else {
                        //当前符号入栈
                        operStack.push(ch);
                    }
                }else {
                    //栈为空，符号入栈
                    operStack.push(ch);
                }
            }else {
                //如果是数直接入数栈
                //numStack.push(ch-48);
                //处理多位数的时候向后看一位
                keepNum+=ch;
                //如果ch是最后一位，入栈
                if (index==experssion.length()-1){
                    numStack.push(Integer.parseInt(keepNum));
                }else {
                    //如果不是最后一位，判断是不是运算符，不是运算符继续走，是运算符入栈
                    if (operStack.isOper(experssion.substring(index+1,index+2).charAt(0))){
                        //是符号入栈
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum="";
                    }
                }

            }
            index++;
            if (index>=experssion.length()){
                break;
            }
        }
        //表达式扫描完毕，顺序的从数栈和符号栈中pop出相应的数和符号，并运行
        while (true){
            //符号栈为空，数栈只有一个数，结果
            if (operStack.isEmpty()){
                break;
            }
            num1=numStack.pop();
            num2=numStack.pop();
            oper=operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);

        }
        int res2 = numStack.pop();
        System.out.println(res2);

    }
}

class ArrayStack2 {
    private int top = -1;
    private int[] stack;
    private int maxSize;

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //取栈顶元素
    public int peek(){
        return stack[top];
    }

    //判断栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //判断栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满，不能入栈");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空，没有数据");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈
    public void list() {
        if (isEmpty()) {
            System.out.println("没有数据");
            return;
        }
        for (int i = top; i > 0; i--) {
            System.out.println(stack[i]);
        }
    }

    //判断符号优先级
    public int priority(int oper){
        if (oper=='*' || oper=='/'){
            return 1;
        }else if (oper=='+' || oper=='-'){
            return 0;
        }else {
            return -1;
        }
    }
    //判断是不是一个运算符
    public boolean isOper(char val){
        return val=='+' || val=='-' || val=='*' || val=='/';
    }
    //计算方法
    public int  cal(int num1,int num2,int oper){
        int res=0;
        switch(oper){
            case '+':
                res=num1+num2;
                break;
            case '-':
                res=num2-num1;
                break;
            case '*':
                res=num1*num2;
                break;
            case '/':
                res=num2/num1;
                break;
            default:
                break;
        }
        return res;

    }

}