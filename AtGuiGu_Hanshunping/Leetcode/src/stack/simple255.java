package stack;

public class simple255 {

    /*Queue<Integer> a =null;
    Queue<Integer> b =null;
    *//** Initialize your data structure here. *//*
    public MyStack() {
        a=new LinkedList<>();
        b=new LinkedList<>();
    }

    *//** Push element x onto stack. *//*
    public void push(int x) {
        a.offer(x);
        while(!b.isEmpty()){
            a.offer(b.poll());
        }
        Queue temp =a;
        a=b;
        b=temp;
    }

    *//** Removes the element on top of the stack and returns that element. *//*
    public int pop() {
        return b.poll();
    }

    *//** Get the top element. *//*
    public int top() {
        return b.peek();
    }

    *//** Returns whether the stack is empty. *//*
    public boolean empty() {
        return b.isEmpty();
    }*/
}
