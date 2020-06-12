package top100;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class medium406 {
    @Test
    public void test(){
        List<Integer> list = new LinkedList<Integer>();
        list.add(1,5);
        list.add(1,7);
        list.add(0,0);
        list.add(2,2);
        list.add(4,2);
        System.out.println(list);
    }
}
