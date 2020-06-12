package com.atguigu.bingfa;

import org.openjdk.jol.info.ClassLayout;

public class SyncDemo {

    public static void main(String[] args) {
        System.out.println(ClassLayout.parseInstance(new T()).toPrintable());
    }
}
