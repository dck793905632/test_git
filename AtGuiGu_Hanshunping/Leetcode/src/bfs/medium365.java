package bfs;

import org.junit.Test;

import java.util.*;

public class medium365 {
    @Test
    public void test(){
        List<Integer> list = Arrays.asList(0,0);
        System.out.println(list );
    }
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (x == 0 || y == 0) {
            return x == z || y == z;
        }
        Queue<List<Integer>> queue = new LinkedList<>();
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> list = Arrays.asList(0, 0);
        queue.offer(list);
        set.add(list);

        while (!queue.isEmpty()) {
            List<Integer> temp = queue.poll();
            int cur_x = temp.get(0);
            int cur_y = temp.get(1);
            if (z == cur_x || z == cur_y || z == cur_x + cur_y) {
                return true;
            }
            //1、给x加满水
            List<Integer> condition1 = Arrays.asList(x, cur_y);
            if (!set.contains(condition1)) {
                set.add(condition1);
                queue.offer(condition1);
            }
            //2、给y加满水
            List<Integer> condition2 = Arrays.asList(cur_x, y);
            if (!set.contains(condition2)) {
                set.add(condition2);
                queue.offer(condition2);
            }
            //3、清空x的水
            List<Integer> condition3 = Arrays.asList(0, cur_y);
            if (!set.contains(condition3)) {
                set.add(condition3);
                queue.offer(condition3);
            }
            //4、清空y的水
            List<Integer> condition4 = Arrays.asList(cur_x, 0);
            if (!set.contains(condition4)) {
                set.add(condition4);
                queue.offer(condition4);
            }
            //5、x给y倒水
            List<Integer> condition5 = (cur_x + cur_y >= y) ?
                    Arrays.asList(cur_x + cur_y - y, y) :
                    Arrays.asList(0, cur_x + cur_y);
            if (!set.contains(condition5)) {
                set.add(condition5);
                queue.offer(condition5);
            }
            //6、y给x倒水
            List<Integer> condition6 = (cur_x + cur_y >= x) ?
                    Arrays.asList(x, cur_x + cur_y - x) :
                    Arrays.asList(cur_x + cur_y, 0);
            if (!set.contains(condition6)) {
                set.add(condition6);
                queue.offer(condition6);
            }
        }
        return false;
    }
}
