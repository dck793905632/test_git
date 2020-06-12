package simple;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class simple1207 {
    @Test
    public void test01(){

    }
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.putIfAbsent(arr[i],0);
            map.put(arr[i],map.get(arr[i])+1);
        }
        Set<Integer> set = new HashSet<>();
        for (Integer key :map.keySet()){
            set.add(map.get(key));
        }
        return set.size()==map.size();
    }
}
