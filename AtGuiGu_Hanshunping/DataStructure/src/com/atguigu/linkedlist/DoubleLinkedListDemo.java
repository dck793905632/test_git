package com.atguigu.linkedlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        HeroNode2 hero1 = new HeroNode2(1,"宋江","及时雨");
        HeroNode2 hero2 = new HeroNode2(2,"卢俊义","玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3,"吴用","智多星");
        HeroNode2 hero33 = new HeroNode2(3,"吴用111","智多星");
        HeroNode2 hero4 = new HeroNode2(6,"林冲","豹子头");
        HeroNode2 hero5 = new HeroNode2(8,"林冲","豹子头");

        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);
        doubleLinkedList.add(hero5);
        System.out.println("输出链表");
        doubleLinkedList.list();


        doubleLinkedList.delete(8);
        System.out.println("删除之后的链表");
        doubleLinkedList.list();

        doubleLinkedList.update(hero33);
        System.out.println("修改之后的链表");
        doubleLinkedList.list();


    }

}

class DoubleLinkedList{

    HeroNode2 head = new HeroNode2(0,"","");


    //向链表顺序添加信息
    public void add(HeroNode2 node){
        HeroNode2 temp = head;
        while (true){
            if (temp.next==null){
                break;
            }
            //不为空，继续往下走
            temp=temp.next;
        }
        //跳出while循环，就是temp的next为空，进行赋值
        //形成双向链表
        temp.next=node;
        node.pre=temp;
    }
    //修改信息
    public void update(HeroNode2 newHeroNode){
        boolean flag = false;
        //声明辅助变量
        HeroNode2 temp = head.next;
        while (true){
            if (temp==null){
                break;
            }
            if (temp.no==newHeroNode.no){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            temp.next.name=newHeroNode.name;
            temp.next.nickname=newHeroNode.nickname;
        }else {
            System.out.println("没有找到编号");
        }
    }
    //删除节点
    public void delete(int n){
        //声明辅助变量
        HeroNode2 temp = head.next;
        boolean flag=false;
        while (true){
            if (temp==null){
                break;
            }
            if (temp.no==n){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            temp.pre.next=temp.next;
            if (temp.next!=null)
                temp.next.pre=temp.pre;
        }else {
            System.out.println("，没有");
        }

    }

    //遍历链表
    public void list(){
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp =head.next;
        while (true){
            if (temp==null){
                break;
            }
            //不为空输出
            System.out.println(temp);
            temp=temp.next;
        }
    }

    public HeroNode2 getHead() {
        return head;
    }
}

class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;

    //构造函数
    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }
    @Override
    public String toString() {
        return "SingleLinked{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
