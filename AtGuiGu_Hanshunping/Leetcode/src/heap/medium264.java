package heap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

public class medium264 {
    public int nthUglyNumber(int n) {
        // Write your code here
        Queue<Long> minHeap = new PriorityQueue<Long>();
        HashSet<Long> set = new HashSet<Long>();
        Long[] primes = new Long[3];
        primes[0] = Long.valueOf(2);
        primes[1] = Long.valueOf(3);
        primes[2] = Long.valueOf(5);
        for (int i = 0; i < 3; i++) {
            minHeap.add(primes[i]);
            set.add(primes[i]);
        }
        Long number = Long.valueOf(1);
        for (int i = 1; i < n; i++) {
            number = minHeap.poll();
            for (int j = 0; j < 3; j++) {
                if (!set.contains(primes[j] * number)) {
                    minHeap.add(number * primes[j]);
                    set.add(number * primes[j]);
                }
            }
        }
        return number.intValue();
    }
}
