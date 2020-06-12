package heap;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test01 {
    @Test
    public void test(){
        Deque<Integer> queue = new ArrayDeque<>();


    }
}
class MaxQueue {
    Queue<Integer> queue;
    Queue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>(){
        public int compare(Integer o1,Integer o2){
            return o2-o1;
        }
    });
    public MaxQueue() {
        queue = new LinkedList<>();
    }

    public int max_value() {
        return maxHeap.peek()==null? -1 :maxHeap.poll();

    }

    public void push_back(int value) {
        queue.offer(value);
        maxHeap.offer(value);
    }

    public int pop_front() {
        if(queue.isEmpty()){
            return -1;
        }
        int p = queue.poll();
        maxHeap.remove(p);
        return p;
    }
}