package com.atguigu.hashAndCon;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.concurrent.ConcurrentHashMap;

public class test01 {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("11",1);
    }
}
