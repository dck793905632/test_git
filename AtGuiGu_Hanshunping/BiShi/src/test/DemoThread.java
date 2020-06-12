package test;
class A {
    static {
        System.out.print("A");
    }
    public A() {
        System.out.print("a");
    }
    void say() {
        System.out.print("1");
    }
}
class B extends A {
    static {
        System.out.print("B");
    }
    public B() {
        System.out.print("b");
    }
    void say() {
        System.out.print("2");
    }
}
public class DemoThread extends Thread {
    public static void main(String[] args) {
        A ab = new B();
        ab.say();
        ab = new B();
        ab.say();
    }
    /*public static void main(String args[]) {
        DemoThread threadOne = new DemoThread();
        DemoThread threadTwo = new DemoThread();
        threadOne.start();
        System.out.print("thread one.");
        threadTwo.start();
        System.out.print("thread two.");
    }
    public void run() {
        System.out.print("Thread.");
    }*/
}
