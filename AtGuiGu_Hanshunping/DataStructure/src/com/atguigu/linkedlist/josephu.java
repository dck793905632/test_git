package com.atguigu.linkedlist;

public class josephu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();
        System.out.println("---------------");
        circleSingleLinkedList.countBoy(1,2,5);
    }
}

class CircleSingleLinkedList{
    //创建一个first的节点，没有编号
    private Boy first=null;


    //根据用户输入，计算小孩出圈顺序
    //startNo 开始的位置
    //countNum 数几次
    //nums 有多少小孩
    public void countBoy(int startNo,int countNum,int nums){
        //判断输入变量
        if (startNo<1 || countNum<0 || countNum>nums){
            System.out.println("输入信息有误，不符合规则");
            return;
        }
        //辅助变量，指向first的上一个节点，最后的节点
        Boy helper = first;
        while (true){
            if (helper.getNext()==first){
                break;
            }
            helper=helper.getNext();
        }
        //helper first定好位置
        //startNo-1
        for (int i=0;i<startNo-1;i++){
            first =first.getNext();
            helper = helper.getNext();
        }

        while (true){
            if (helper==first){
                break;
            }
            //countNum-1
            for (int j=0;j<countNum-1;j++){
                helper=helper.getNext();
                first=first.getNext();
            }
            System.out.println(first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println();
        System.out.println("最后剩下的小孩编号"+first.getNo());


    }

    //添加小孩节点，构建成一个环形链表
    public void addBoy(int nums){
        //校验nums
        if (nums<1){
            return;
        }
        Boy curBoy = null;
        for (int i =1;i<=nums;i++){
            Boy boy = new Boy(i);
            if (i==1){
                first=boy;
                first.setNext(boy);
                curBoy=first;
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy=boy;
            }
        }
    }
    //遍历环形列表
    public void showBoy(){
        //判断是否为空
        if (first==null){
            System.out.println("为空");
            return;
        }
        //声明辅助变量
        Boy curBoy = first;
        while (true){
            System.out.println(curBoy.getNo());
            if (curBoy.getNext()==first){
                break;
            }
            curBoy=curBoy.getNext();
        }
    }
}

//Boy节点
class Boy{
    private int no;
    private Boy next;

    public Boy(int no){
        this.no=no;
    }
    public void setNo(int no){
        this.no=no;
    }
    public int getNo(){
        return no;
    }
    public void setNext(Boy next){
        this.next=next;
    }
    public Boy getNext(){
        return next;
    }
}
