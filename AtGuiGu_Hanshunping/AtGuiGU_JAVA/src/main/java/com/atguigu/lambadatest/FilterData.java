package com.atguigu.lambadatest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterData {
    @Test
    public void test(){
        List<Student> list =new ArrayList<>();
        list.add(new Student("a",30,false));
        list.add(new Student("b",40,true));
        list.add(new Student("c",80,false));
        list.add(new Student("d",70,true));
        list.add(new Student("e",50,false));
        list.add(new Student("f",60,false));
        list.add(new Student("g",90,true));

        List<Student> res = list.stream().filter(item -> item.getScore() > 60).collect(Collectors.toList());
        //res.forEach(item-> System.out.println(item.getName()+" "+item.getScore()));
        String s = list.stream().filter(item -> item.isFlag() == true).map(item->item.getName()).collect(Collectors.toList()).toString();
        System.out.println(s);
    }
}
class Student{
    private int score;
    private String name;
    private boolean flag;
    public Student(String name,int score,boolean flag){
        this.name=name;
        this.score=score;
        this.flag=flag;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}