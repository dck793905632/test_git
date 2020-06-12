package com.atguigu.hashtab;

import java.util.Scanner;

public class HashTabDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);

        Scanner scanner = new Scanner(System.in);

        String key="";
        while (true){
            System.out.println("add 添加");
            System.out.println("list 显示");
            System.out.println("find 查找");
            System.out.println("exit 退出");
            key=scanner.next();
            switch(key){
            case "add":
                System.out.println("请输入id");
                int id =scanner.nextInt();
                System.out.println("请输入姓名");
                String name = scanner.next();
                Emp emp = new Emp(id,name);
                hashTab.add(emp);
                break;
            case "list":
                hashTab.list();
                break;
            case "find":
                System.out.println("请输入要查询的id");
                id = scanner.nextInt();
                hashTab.findEmpById(id);
                break;
            default:
                    break;
            }
        }



    }
}



class HashTab{
    private EmpLinkedList[] empLinkedListArray;
    public int size;

    public HashTab(int size){
        this.size=size;
        empLinkedListArray=new EmpLinkedList[size];
        for (int i =0;i<size;i++){
            empLinkedListArray[i]=new EmpLinkedList();
        }
    }

    public void add(Emp emp){
        int empLinkedListNo =hasFun(emp.id);
        empLinkedListArray[empLinkedListNo].add(emp);
    }

    public void list(){
        for (int i=0;i<size;i++){
            empLinkedListArray[i].list(i);
        }
    }
    public void findEmpById(int id){
        int empLinkedListNo = hasFun(id);
        Emp emp = empLinkedListArray[empLinkedListNo].findEmpById(id);
        if (emp!=null){
            System.out.println((empLinkedListNo+1)+"条链表的数据 id="+emp.id);
        }else {
            System.out.println("没有该数据");
        }

    }

    public int hasFun(int id){
        return id % size;
    }
}
class Emp{
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
class EmpLinkedList{
    private Emp head;

    public void add(Emp emp){
        if (head==null){
            head=emp;
            return;
        }
        Emp curEmp = head;
        while (true){
            if (curEmp.next==null){
                break;
            }
            curEmp=curEmp.next;
        }
        curEmp.next=emp;
    }

    public void list(int no){
        if (head==null){
            System.out.println((no+1)+"条链表为空");
            return;
        }
        System.out.print((no+1)+"条链表数据为");
        Emp curEmp = head;
        while (true){
            System.out.printf(" =>id=%d name=%s\t",curEmp.id,curEmp.name);
            if (curEmp.next==null){
                break;
            }
            curEmp=curEmp.next;

        }
        System.out.println();
    }
    public Emp findEmpById(int id){
        if (head==null){
            return null;
        }
        Emp curEmp = head;
        while (true){
            if (curEmp.id==id){
                break;
            }
            if (curEmp.next==null){
                curEmp=null;
                break;
            }
            curEmp=curEmp.next;
        }
        return curEmp;
    }
}
