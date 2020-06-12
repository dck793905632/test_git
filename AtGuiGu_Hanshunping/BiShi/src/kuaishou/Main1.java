package kuaishou;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strs = str.split(" ");
        int[] arr = new int[strs.length];
        for(int i=0;i<arr.length;i++){
            arr[i]=Integer.valueOf(strs[i]);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i=1;i<arr.length;i++){
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if(arr[j]>arr[i]){
                    list.add(i);
                }
            }
            res.add(list);
        }
        String ss= "";
        for(List<Integer> l : res){
            if (l.size()==1){
                ss+=l.get(0)+" ";
            }
        }
        if(ss.equals("")){
            System.out.println(-1);
        }
        System.out.println(ss.trim());
    }
}
