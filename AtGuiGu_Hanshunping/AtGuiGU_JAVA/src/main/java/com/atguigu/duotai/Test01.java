package com.atguigu.duotai;

class Dance {
    public void play(){
        System.out.println("Dance.play");
    }
    public void play(int i){
        System.out.println("Dance.play" + i);
    }
}

class Latin extends Dance {
    public void play(){
        System.out.println("Latin.play");
    }
    public void play(char c){
        System.out.println("Latin.play" + c);
    }
}
class Jazz extends Dance {
    public void play(){
        System.out.println("Jazz.play");
    }
    public void play(double d){
        System.out.println("Jazz.play" + d);
    }
}
public class Test01 {
    public void perform(Latin dance){
        dance.play();
    }
    public void perform(Jazz dance){
        dance.play();
    }
    public static void main(String[] args){
        Test01 test01 = new Test01();
        Jazz jazz = new Jazz();
        test01.perform(jazz);
        test01.perform(new Latin());
    }
}
