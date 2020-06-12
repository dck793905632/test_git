package com.atguigu.huawei;

public class A {
    int i;
    void show(){
        System.out.println(i++);
    }

    public static void main(String[] args) {
        A a = new B();
        a.show();
    }
}
class B extends A{
    void show(){
        i++;
        super.show();
    }
}
