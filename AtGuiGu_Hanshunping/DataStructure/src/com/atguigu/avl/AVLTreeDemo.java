package com.atguigu.avl;

public class AVLTreeDemo {
    public static void main(String[] args) {
        //int[] arr={10,12,8,9,7,6};
        int[] arr={10,11,7,6,8,9};
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }
        avlTree.infixOrder();
        int hight = avlTree.getRoot().hight();
        System.out.println(hight);
        System.out.println(avlTree.getRoot().leftHight());
        System.out.println(avlTree.getRoot().rightHight());
    }
}
class AVLTree{
    Node root;

    public Node getRoot() {
        return root;
    }

    public Node search(int value){
        if (root==null){
            return null;
        }else {
            return root.search(value);
        }
    }

    public Node searchParent(int value){
        if (root==null){
            return null;
        }else {
            return root.searchParent(value);
        }
    }
    public int delRightTreeMin(Node node){
        Node target = node;
        while (target.left!=null){
            target=target.left;
        }
        delNode(target.value);
        return target.value;
    }

    public void delNode(int value){
        if (root==null){
            return;
        }else {
            Node targetNode = search(value);
            if (targetNode==null){
                return;
            }
            if (root.left==null&&root.right==null){
                root=null;
                return;
            }
            Node parent = searchParent(value);
            //删除叶子结点
            if (targetNode.left==null&&targetNode.right==null){
                if (parent.left!=null&&parent.left.value==value){
                    parent.left=null;
                }else if (parent.right!=null&&parent.right.value==value){
                    parent.right=null;
                }
            }else if (targetNode.left!=null&&targetNode.right!=null){
                //删除有两个子节点的节点
                int minVal = delRightTreeMin(targetNode);
                targetNode.value=minVal;
            }else {
                //删除有一个子节点的节点
                if (targetNode.left!=null){
                    if (parent!=null){
                        if (parent.left.value==value){
                            parent.left=targetNode.left;
                        }else {
                            parent.right=targetNode.left;
                        }
                    }else {
                        root=targetNode.left;
                    }
                }else {
                    if (parent!=null){
                        if (parent.left.value==value){
                            parent.left=targetNode.right;
                        }else {
                            parent.right=targetNode.right;
                        }
                    }else {
                        root=targetNode.right;
                    }
                }
            }
        }
    }
    public void add(Node node){
        if (this.root==null){
            this.root=node;
        }else {
            this.root.add(node);
        }
    }

    public void infixOrder(){
        if (this.root==null){
            return;
        }else {
            this.root.infixOrder();
        }
    }
}
//创建节点
class Node{
    int value;
    Node left;
    Node right;

    public void rightRotate(){
        //创建一个新节点等于当前节点
        Node newNode = new Node(this.value);
        //新节点的右子树设置为当前节点右子树
        newNode.right=this.right;
        //新节点的左子树设置为当前节点的左子树的右子树
        newNode.left=this.left.right;
        //当前节点的值换为左子节点的值
        this.value=this.left.value;
        //当前节点的左子树设置为左子树的左子树
        this.left=left.left;
        //当前节点的右子树设置为新节点
        this.right=newNode;
    }
    public void leftRotate(){
        //创建一个新节点等于当前根节点
        Node newNode = new Node(this.value);
        //新节点的左子树设置为当当前节点的左子树
        newNode.left=this.left;
        //新节点的右子树设置为当前节点的右子树的左子树
        newNode.right=this.right.left;
        //当前节点的值换为右子节点的值
        this.value=this.right.value;
        //当前节点的右子树换为右子树的右子树
        this.right=right.right;
        //当前节点的左子树设置为新节点
        this.left=newNode;
    }
    public int rightHight(){
        if (this.right==null){
            return 0;
        }
        return this.right.hight();
    }
    public int leftHight(){
        if (this.left==null){
            return 0;
        }
        return this.left.hight();
    }
    public int hight(){
        return Math.max(this.left==null ? 0:this.left.hight(),this.right==null? 0:this.right.hight())+1;
    }
    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    //查找当前节点
    public Node search(int value){
        if (this.value==value){
            return this;
        }else if (value<this.value){
            if (this.left==null){
                return null;
            }
            return this.left.search(value);
        }else {
            if (this.right==null){
                return null;
            }
            return this.right.search(value);
        }
    }

    //查找当前节点的父节点

    public Node searchParent(int value){
        if ((this.left!=null&&this.left.value==value)||(this.right!=null&&this.right.value==value)){
            return this;
        }else {
            if (value<this.value&&this.left!=null){
                return this.left.searchParent(value);
            }else if (value>this.value&&this.right!=null){
                return this.right.searchParent(value);
            }else {
                return null;
            }
        }
    }

    public void add(Node node){
        if (node==null){
            return;
        }
        if (node.value<this.value){
            if (this.left==null){
                this.left=node;
            }else {
                this.left.add(node);
            }
        }else {
            if (this.right==null){
                this.right=node;
            }else {
                this.right.add(node);
            }
        }
        if (rightHight()-leftHight()>1){
            if (right!=null&&right.leftHight()>right.rightHight()){
                right.rightHight();
                leftRotate();
            }else {
                leftRotate();
            }
            return;
        }
        if (leftHight()-rightHight()>1){
            if (left!=null&&left.rightHight()>left.leftHight()){
                left.leftRotate();
                rightRotate();
            }else {
                rightRotate();
            }
        }
    }

    //中序遍历
    public void infixOrder(){
        if (this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right!=null){
            this.right.infixOrder();
        }
    }
}
