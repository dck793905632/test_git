package medium;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class mediumLRU146 extends LinkedHashMap<Integer,Integer>{

    @Test
    public void test(){
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1,1);
    }


}
class LRUCache extends LinkedHashMap<Integer, Integer>{
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    // 这个可不写
    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}

