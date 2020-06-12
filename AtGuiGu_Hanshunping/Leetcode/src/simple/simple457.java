package simple;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class simple457 {
    @Test
    public void test01(){
        int[] houses=new int[]{1,2,3,4};
        int[] heaters = new int[]{1,4};
        System.out.println(findRadius(houses,heaters));
    }
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<houses.length;i++){
            int left=0;
            int right=heaters.length-1;
            while (left<right){
                int mid = (left+right)>>1;
                if (heaters[mid]<houses[i]){
                    left=mid+1;
                }else {
                    right=mid;
                }
            }
            if (heaters[left]==houses[i]){
                list.add(0);
            }else if (heaters[left]<houses[i]){
                list.add(houses[i]-heaters[left]);
            }else if (heaters[left]>houses[i]&&left!=0){
                list.add(Math.min(heaters[left]-houses[i],houses[i]-heaters[left-1]));
            }else {
                list.add(heaters[left]-houses[i]);
            }
        }
        int max=Integer.MIN_VALUE;
        for(int l:list){
            if (max<l){
                max=l;
            }
        }
        return max;
    }
}
