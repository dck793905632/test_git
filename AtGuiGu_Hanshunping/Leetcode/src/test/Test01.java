package test;

import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.io.ByteArrayOutputStream;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test01{
    public static void main(String[] args) {
       /* Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){

            int n =scanner.nextInt();
            System.out.println(n);
        }*/
        /*System.out.println('x'-0);
        List<String> list = new ArrayList<>();*/
        /*System.out.println(2^4);
        Integer.bitCount(2^4);*/
        Map<String,Integer> map = new HashMap<>();
        System.out.println(map.get("1"));
    }

    public List<String> topKFrequent(String[] strs) {
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            map.putIfAbsent(strs[i],0);
            map.put(strs[i],map.get(strs[i])+1);
        }
        Queue<String> minHeap = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o2)-map.get(o1);
            }
        });
        for (String key : map.keySet()){
            minHeap.offer(key);
        }

        List<String> res = new ArrayList<>();
        for(int i=0;i<10;i++){
            res.add(minHeap.poll());
        }
        return res;
    }

    @Test
    public void test02(){
        System.out.println(countOccurrences("abcdefd",'d'));
    }

    public  int countOccurrences(String str, char ch) {
        int num = 0;
        int index = -1;
        do {
            index = str.indexOf(ch, index + 1);
            if (index >= 0) {
                num++;
            }
        } while (index >= 0);
        return num;
    }
    private static boolean instanceOfAny(Object o,
                  Collection<Class> classes){
        for(Class c: classes){
            if (c.isInstance(o))
                return true;
        }
        return false;
    }

    @Test
    public void test1(){
        System.out.println(1<<4);
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> list =new ArrayList<>();
        list.remove(list.size()-1);
    }
}
