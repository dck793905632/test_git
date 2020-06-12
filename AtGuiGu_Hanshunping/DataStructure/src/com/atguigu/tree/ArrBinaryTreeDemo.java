package com.atguigu.tree;

public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder();
        //arrBinaryTree.infixOrder();
        //arrBinaryTree.postOrder();
    }
}
class ArrBinaryTree{
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }
    public void preOrder(){
        this.preOrder(0);
    }

    public void infixOrder(){
        this.infixOrder(0);
    }

    public void postOrder(){
        this.postOrder(0);
    }

    //前序遍历
    public void preOrder(int index){
        if (arr==null || arr.length==0){
            System.out.println("数组为空");
        }
        System.out.println(arr[index]);
        if (index*2+1<arr.length){
            preOrder(index*2+1);
        }
        if (index*2+2<arr.length){
            preOrder(index*2+2);
        }
    }

    //中序遍历
    public void infixOrder(int index){
        if (arr==null || arr.length==0){
            System.out.println("111");
        }
        if (index*2+1<arr.length){
            infixOrder(index*2+1);
        }
        System.out.println(arr[index]);
        if (index*2+2<arr.length){
            infixOrder(index*2+2);
        }
    }
    //后序遍历
    public void postOrder(int index){
        if (arr.length==0||arr==null){
            System.out.println("111");
        }
        if (index*2+1<arr.length){
            postOrder(index*2+1);
        }
        if (index*2+2<arr.length){
            postOrder(index*2+2);
        }
        System.out.println(arr[index]);
    }
}
