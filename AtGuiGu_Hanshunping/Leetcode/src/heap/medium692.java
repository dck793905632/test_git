package heap;

import java.util.*;

public class medium692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<words.length;i++){
            map.putIfAbsent(words[i],0);
            map.put(words[i],map.get(words[i])+1);
        }
        Queue<String> maxHeap = new PriorityQueue<>(new Comparator<String>(){
            public int compare(String o1,String o2){
                return map.get(o1).equals(map.get(o2))? o1.compareTo(o2):map.get(o2)-map.get(o1);
            }
        });
        for(String key:map.keySet()){
            maxHeap.offer(key);
        }
        List<String> res = new ArrayList<>();
        for(int i=0;i<k;i++){
            res.add(maxHeap.poll());
        }
        return res;
    }
}
