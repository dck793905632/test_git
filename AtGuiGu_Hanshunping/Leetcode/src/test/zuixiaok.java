package test;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class zuixiaok {
    @Test
    public void test(){
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        queue.offer(2);
        queue.offer(4);
        queue.offer(1);
        queue.offer(0);
        Map<String,Integer> map =new HashMap<>();
        map.put("a",2);
        map.put("c",5);
        map.put("g",0);
        map.put("h",3);
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        System.out.println(list);




    }
    public double myPow(int x ,int n){
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res*=x;
        }
        System.out.println(res);
        return 1;
    }


}
