package com.atguigu.linkedlist;

import java.awt.*;
import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();
//        HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
//        HeroNode hero2 = new HeroNode(2,"卢俊义","玉麒麟");
//        HeroNode hero3 = new HeroNode(3,"吴用","智多星");
//        HeroNode hero4 = new HeroNode(4,"林冲","豹子头");

        HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
        HeroNode hero2 = new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode hero3 = new HeroNode(4,"吴用","智多星");
        HeroNode hero4 = new HeroNode(6,"林冲","豹子头");
        HeroNode hero5 = new HeroNode(8,"林冲","豹子头");
        linkedList.addByOrder(hero1);
        linkedList.addByOrder(hero2);
        linkedList.addByOrder(hero3);
        linkedList.addByOrder(hero4);
        linkedList.addByOrder(hero5);
        //遍历链表
        //linkedList.list();

        SingleLinkedList linkedList1 = new SingleLinkedList();
        HeroNode hero11 = new HeroNode(3,"宋江","及时雨");
        HeroNode hero22 = new HeroNode(4,"卢俊义","玉麒麟");
        HeroNode hero33 = new HeroNode(7,"吴用","智多星");
        HeroNode hero44 = new HeroNode(8,"林冲","豹子头");
        HeroNode hero55 = new HeroNode(9,"林冲","豹子头");
        linkedList1.addByOrder(hero11);
        linkedList1.addByOrder(hero22);
        linkedList1.addByOrder(hero33);
        linkedList1.addByOrder(hero44);
        linkedList1.addByOrder(hero55);

        linkedList.list();
        linkedList1.list();
        HeroNode heroNode = mergeList(linkedList.getHead(), linkedList1.getHead());
        SingleLinkedList list = new SingleLinkedList();
        list.add(heroNode);
        list.list();

//        System.out.println("反转之后的链表");
//        resversetList(linkedList.getHead());
//        linkedList.list();
//        System.out.println("逆序输出");
//        resversetPrint(linkedList.getHead());
//        HeroNode newhero2 = new HeroNode(2,"小撸","玉麒麟~~~~");
//
//        linkedList.update(newhero2);
//
//        //修改后遍历
//        //linkedList.list();
//        linkedList.delete(3);
//        //删除后遍历
//        linkedList.list();
//        int length = getLength(linkedList.getHead());
//        System.out.println(length);
//
//        HeroNode lastIndexNode = getLastIndexNode(linkedList.getHead(), 10);
//        System.out.println(lastIndexNode);


    }

    //获得链表长度，除头结点
    public static int getLength(HeroNode head){
        int length=0;
        if (head==null){
            return 0;
        }
        HeroNode cur = head.next;
        while (cur!=null){
            length++;
            cur=cur.next;
        }
        return length;
    }

    //获取倒数第index个节点
    public static HeroNode getLastIndexNode(HeroNode head,int index){
        int size = getLength(head);
        if (head==null){
            return null;
        }
        if (index<=0 || index>size){
            return null;
        }
        HeroNode cur = head.next;
        for (int i=0;i<size-index;i++){
            cur=cur.next;
        }
        return cur;
    }


    //合并两个有序链表
    public static HeroNode mergeList(HeroNode head1,HeroNode head2){
        if (head1==null){
            return head2;
        }
        if (head2==null){
            return head1;
        }

        HeroNode prehead=new HeroNode(-1,"","");
        HeroNode pre = prehead;
        while (head1.next!=null && head2.next!=null){
            if (head1.next.no<=head2.next.no){
                pre.next=head1.next;
                head1.next=head1.next.next;

            }else {
                pre.next=head2.next;
                head2.next=head2.next.next;
            }
            pre=head1.next==null?head2.next:head1.next;
        }
        return prehead.next;
    }

    //链表的逆序输出不改变链表结构
    public static void resversetPrint(HeroNode head){
        if (head==null){
            return;
        }
        //head不为空，声明辅助变量
        HeroNode cur = head.next;
        Stack<HeroNode> stack=new Stack<HeroNode>();
        while (cur!=null){
            stack.add(cur);
            cur=cur.next;
        }
        //遍历栈
        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }
    //链表反转
    public static void resversetList(HeroNode head){
        if (head.next==null || head.next.next==null){
            return;
        }
        HeroNode cur =head.next;
        HeroNode next = null;
        HeroNode resversetHead = new HeroNode(0,"","");
        while (cur!=null){
            next=cur.next;
            cur.next=resversetHead.next;
            resversetHead.next=cur;
            cur=next;
        }
        head.next=resversetHead.next;
    }
}
class SingleLinkedList{
    HeroNode head=new HeroNode(0,"","");


    //向链表顺序添加信息
    public void add(HeroNode node){
        HeroNode temp = head;
        while (true){
            if (temp.next==null){
                break;
            }
            //不为空，继续往下走
            temp=temp.next;
        }
        //跳出while循环，就是temp的next为空，进行赋值
        temp.next=node;
    }

    //第二种添加方式，排序
    public void addByOrder(HeroNode node){
        //声明辅助变量
        HeroNode temp = head;
        boolean flag =false;
        while (true){
            if (temp.next==null){
                break;
            }
            if (temp.next.no>node.no){
                break;
            }else if (temp.next.no==node.no){
                flag=true;
                break;
            }
            temp=temp.next;

        }
        if (flag){
            System.out.println("当前编号英雄已存在");
        }else {
            node.next=temp.next;
            temp.next=node;
        }

    }

    //修改信息
    public void update(HeroNode newHeroNode){
        boolean flag = false;
        //声明辅助变量
        HeroNode temp = head;
        while (true){
            if (temp.next==null){
                break;
            }
            if (temp.next.no==newHeroNode.no){
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
        HeroNode temp = head;
        boolean flag=false;
        while (true){
            if (temp.next==null){
                break;
            }
            if (temp.next.no==n){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            temp.next=temp.next.next;
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
        HeroNode temp =head.next;
        while (true){
            if (temp==null){
                break;
            }
            //不为空输出
            System.out.println(temp);
            temp=temp.next;
        }
    }

    public HeroNode getHead() {
        return head;
    }
}
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;
    //构造函数
    public HeroNode(int no,String name,String nickname){
        this.no=no;
        this.name=name;
        this.nickname=nickname;
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
