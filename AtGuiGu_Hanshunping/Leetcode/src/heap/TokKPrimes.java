package heap;

import org.junit.Test;

import java.util.*;

public class TokKPrimes {

    @Test
    public void test(){
        int[] nums = new int[]{1,1,1,2,2,3,4};
        System.out.println(topKFrequent(nums,2));
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.putIfAbsent(nums[i],0);
            map.put(nums[i],map.get(nums[i])+1);
        }
        Queue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2)-map.get(o1);
            }
        });
        for (Integer key : map.keySet()){
            minHeap.offer(key);
        }
        while (!minHeap.isEmpty()){
            System.out.println(minHeap.poll());
        }
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<k;i++){
            res.add(minHeap.poll());
        }
        return res;
    }
}
