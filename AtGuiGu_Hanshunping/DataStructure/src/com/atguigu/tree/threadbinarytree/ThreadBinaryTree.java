package com.atguigu.tree.threadbinarytree;

public class ThreadBinaryTree {
    public static void main(String[] args) {
        HeroNode root = new HeroNode(1,"a");
        HeroNode node2 = new HeroNode(3,"b");
        HeroNode node3 = new HeroNode(6,"c");
        HeroNode node4= new HeroNode(8,"d");
        HeroNode node5 = new HeroNode(10,"e");
        HeroNode node6= new HeroNode(14,"f");

        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        ThreadedBinaryTree threadedBinaryTree= new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNodes();

//        HeroNode node5Left = node5.getLeft();
//        HeroNode node5Right = node5.getRight();
//        System.out.println(node5Left);
//        System.out.println(node5Right);
        threadedBinaryTree.threadedList(root);

    }
}

class ThreadedBinaryTree{
    private HeroNode root;
    private HeroNode pre =null;

    public HeroNode getRoot() {
        return root;
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }


    public void threadedList(HeroNode root){
        if (root==null){
            return;
        }
        HeroNode node = root;

        while (node!=null){

            while (node.getLeftType()==0){
                node=node.getLeft();
            }

            System.out.println(node);

            while (node.getRightType()==1){
                node=node.getRight();
                System.out.println(node);
            }
            node=node.getRight();
        }
    }

    public void threadedNodes(){
        this.threadedNodes(root);
    }
    public void threadedNodes(HeroNode node){
        if (node==null){
            return;
        }
        //1先线索左子树
        threadedNodes(node.getLeft());
        //2线索当前节点
        if(node.getLeft()==null){
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if (pre!=null && pre.getRight()==null){
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre=node;
        //3线索右子树
        threadedNodes(node.getRight());
    }
}

class HeroNode {
    private int id;
    private String name;
    private HeroNode left;
    private HeroNode right;

    private int leftType;
    private int rightType;
    public HeroNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
