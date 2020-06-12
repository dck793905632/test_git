package simple;

import java.util.*;

public class simple1341 {
    public int[] kWeakestRows(int[][] mat, int k) {
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0;i<mat.length;i++){
            int count = 0;
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j] ==1){
                    count++;
                }else {
                    break;
                }
            }
            map.put(i,count);
        }
        List<Integer> indexList = new ArrayList(mat.length);
        for(int i=0;i<mat.length;i++){
            indexList.add(i);
        }
        Collections.sort(indexList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1)-map.get(o2);
            }
        });
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = indexList.get(i);
        }
        return res;


    }
}
