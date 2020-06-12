package com.atguigu.java01;

import java.io.IOException;
import java.io.ObjectInputStream;

public class jicheng {
    private int age;
    public int hight;

    public static void test001(){

    }
    private int t(){
        return 1;
    }

}

class jiji extends  jicheng{
    public static void main(String[] args) {
        test1();
    }
    public static void test1(){
        jiji jiji = new jiji();
        jicheng jicheng = new jicheng();
        int t = jiji.t();
        System.out.println(t);


    }
    public static void test001() {
        jiji jiji = new jiji();
        try {
            Object clone = jiji.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        try {
            Object jiji1 = Class.forName("jiji").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private int t(){
        return 2;
    }
}
