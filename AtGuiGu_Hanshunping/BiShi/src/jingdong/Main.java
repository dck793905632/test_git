package jingdong;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();*/
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            Map<Integer,Integer> map = new HashMap<>();
            boolean res = true;
            for (int j = 0; j < 6; j++) {
                int h =scanner.nextInt();
                int w =scanner.nextInt();
                map.putIfAbsent(h,0);
                map.putIfAbsent(w,0);
                map.put(h,map.get(h)+1);
                map.put(w,map.get(w)+1);
            }

            for(int key : map.keySet()) {
                if(key==0){
                    res=false;
                    break;
                }
                if (map.get(key) !=4 && map.get(key)!=8 && map.get(key)!=12) {
                    res = false;
                }
            }
            if (map.size()==1){
                res=false;
            }
            if (res){
                System.out.println("POSSIBLE");
            }else {
                System.out.println("IMPOSSIBLE");
            }
        }


    }
}

/*
* Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < 6; j++) {
                int h =scanner.nextInt();
                int w =scanner.nextInt();
            }
        }
        System.out.println("POSSIBLE");
        System.out.println("IMPOSSIBLE");
* */
