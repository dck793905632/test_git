package com.atguigu.di2ji;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

class User{
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        User zs = new User("z2",23);
        User lisi = new User("lisi",23);
        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(zs);
        atomicReference.compareAndSet(zs,lisi);
        Set<String> set = new HashSet<>();
        set.add("a");
        Map<String,Integer> map = new HashMap();
        map.put("a",2);
        Map<String,Integer> map1 = new ConcurrentHashMap<>();

    }
}
