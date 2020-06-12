package com.atguigu;

import java.util.LinkedList;
import java.util.Queue;

public class newtest {
    public static void main(String[] args) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.addLast(1);
        queue.addLast(2);
        queue.addLast(3);
        queue.addFirst(1);
        queue.addFirst(2);
        queue.addFirst(3);


        System.out.println(queue);
    }
}
