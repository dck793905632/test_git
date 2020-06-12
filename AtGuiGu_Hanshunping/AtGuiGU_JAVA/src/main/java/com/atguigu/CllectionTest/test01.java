package com.atguigu.CllectionTest;

import java.util.*;

public class test01 {
    public static void main(String[] args) {
        Map<String,Integer> map = new LinkedHashMap<>();
        map.put("a",1);
        map.put("b",1);
        map.put("d",1);
        map.put("c",1);
        for (String key : map.keySet()){
            System.out.println(map.get(key));
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry);
        }
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new LinkedList<>();
    }

}
