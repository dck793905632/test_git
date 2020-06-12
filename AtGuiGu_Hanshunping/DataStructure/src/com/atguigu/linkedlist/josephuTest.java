package com.atguigu.linkedlist;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class josephuTest {
    public static void main(String[] args) {
        clink clink1 = new clink();
        clink1.add(5);
        clink1.print();
        Queue<Integer> queue = new LinkedList<>();
        queue.peek();

        Stack<Integer> stack = new Stack<>();
        stack.push(1);

    }

}

class clink{
    private boy1 first=null;
    public void add(int n){
        if (n<1){
            return;
        }
        boy1 curboy = null;
        for (int i=1;i<=n;i++){
            boy1 boy1 = new boy1(i);
            if (i==1){
                first=boy1;
                first.setNext(first);
                curboy=first;
            }else {
                curboy.setNext(boy1);
                boy1.setNext(first);
                curboy=boy1;
            }
        }
    }
    public void print(){
        if (first==null){
            return;
        }
        boy1 cur = first;
        while (true){
            if (cur.getNext()==first){
                System.out.println(cur.getNo());
                break;
            }
            System.out.println(cur.getNo());
            cur=cur.getNext();
        }
    }
}


class boy1{
    private int no;

    public boy1(int no){
        this.no=no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public boy1 getNext() {
        return next;
    }

    public void setNext(boy1 next) {
        this.next = next;
    }

    private boy1 next;
}
