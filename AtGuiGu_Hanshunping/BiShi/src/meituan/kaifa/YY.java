package meituan.kaifa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class YY {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int L = scanner.nextInt();
        int R = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> list1 = new ArrayList<>();

        helper(n,k,L,R,list,list1);
        System.out.println(list1.size());

    }
    public static void helper(int n,int k,int L,int R,List<Integer> list,List<List<Integer>> list1){
        if(list.size()==n){
            int count=0;
            for(int x : list){
                count+=x;
            }
            if(count%k==0){
                list1.add(new ArrayList<Integer>(list));
                return;
            }

        }

        for(int l=L;l<=R;l++){
            list.add(l);
            helper(n,k,L,R,list,list1);
            list.remove(list.size()-1);
        }


    }
}
