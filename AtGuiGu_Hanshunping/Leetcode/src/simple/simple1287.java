package simple;

import java.util.HashMap;
import java.util.Map;

public class simple1287 {
    public static void main(String[] args) {

    }
    public int findSpecialInteger(int[] arr) {
        int i,j;
        for (i=0;i<arr.length-arr.length/4;i+=arr.length/4){
            if (arr[i]==arr[i+2]){
                return arr[i];
            }
        }
        return -1;
    }
    /*public int findSpecialInteger(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.putIfAbsent(arr[i],0);
            map.put(arr[i],map.get(arr[i])+1);
        }
        for (Integer key:map.keySet()){
            if (map.get(key)>arr.length/4){
                return key;
            }
        }
        return -1;
    }*/
}
