package com.atguigu.tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode root = new HeroNode(1, "a");
        HeroNode node2 = new HeroNode(2, "b");
        HeroNode node3 = new HeroNode(3, "c");
        HeroNode node4 = new HeroNode(4, "d");
        HeroNode node5 = new HeroNode(5, "e");
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);

        binaryTree.setRoot(root);

        //binaryTree.preOrder();
        //binaryTree.infixOrder();
        //binaryTree.postOrder();
       /* HeroNode node = binaryTree.preOrderSearch(root, 12);
        System.out.println(node);
        HeroNode node1 = binaryTree.InfixOrderSearch(root, 12);
        System.out.println(node1);
        HeroNode node5 = binaryTree.postOrderSearch(root, 12);
        System.out.println(node5);*/

        binaryTree.preOrder();
        binaryTree.delNode(5);
        binaryTree.preOrder();

    }


}

class BinaryTree{
    private HeroNode root;

    public HeroNode getRoot() {
        return root;
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //删除节点
    public void delNode(int no){
        if (this.root!=null){
            if (this.root.getId()==no){
                root=null;
            }else {
                root.delNode(no);
            }
        }else {
            System.out.println("无");
        }
    }
    //前序遍历
    public void preOrder(){
        if (this.root!=null){
            this.root.preOrder();
        }else {
            System.out.println("空");
        }
    }
    //中序遍历
    public void infixOrder(){
        if (this.root!=null){
            this.root.infixOrder();
        }else {
            System.out.println("空");
        }
    }
    //后序遍历
    public void postOrder(){
        if (this.root!=null){
            this.root.postOrder();
        }else {
            System.out.println("空");
        }
    }
    public HeroNode preOrderSearch(HeroNode root,int no){
        if (root!=null){
            return this.root.preOrderSearch(no);
        }else {
            return null;
        }
    }

    public HeroNode InfixOrderSearch(HeroNode root,int no){
        if (root!=null){
            return this.root.infixOrderSearch(no);
        }else {
            return null;
        }
    }

    public HeroNode postOrderSearch(HeroNode root,int no){
        if (root!=null){
            return this.root.postOrderSearch(no);
        }else {
            return null;
        }
    }
}
class HeroNode{
    private int id;
    private String name;
    private HeroNode left;
    private HeroNode right;

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

    @Override
    public String toString() {
        return "HeroNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    //层次遍历
    public void levelOrder(){
        System.out.println(this);

        if (this.left!=null){
            System.out.println(this.left);
            this.left.levelOrder();
        }
        if (this.right!=null){
            System.out.println(this.right);
            this.right.levelOrder();
        }
    }
    //删除节点
    public void delNode(int no){
        if (this.left!=null && this.left.id==no){
            this.left=null;
            return;
        }
        if (this.right!=null && this.right.id==no){
            this.right=null;
            return;
        }
        if (this.left!=null){
            this.left.delNode(no);
        }
        if (this.right!=null){
            this.right.delNode(no);
        }
    }
    //前序遍历
    public void preOrder(){
        System.out.println(this.toString());
        if (this.left!=null){
            this.left.preOrder();
        }
        if (this.right!=null){
            this.right.preOrder();
        }
    }
    //中序遍历
    public void infixOrder(){
        if (this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this.toString());
        if (this.right!=null){
            this.right.infixOrder();
        }
    }
    //后序遍历
    public void postOrder(){
        if (this.left!=null){
            this.left.postOrder();
        }
        if (this.right!=null){
            this.right.postOrder();
        }
        System.out.println(this.toString());
    }

    public HeroNode preOrderSearch(int no){
        if (this.id==no){
            return this;
        }
        HeroNode resNode = null;
        if (this.left!=null){
            resNode=this.left.preOrderSearch(no);
        }
        if (resNode!=null){
            return resNode;
        }
        if (this.right!=null){
            resNode=this.right.preOrderSearch(no);
        }
        return resNode;
    }

    public HeroNode infixOrderSearch(int no){
        HeroNode resNode = null;
        if (this.left!=null){
            resNode=this.left.infixOrderSearch(no);
        }
        if (resNode!=null){
            return resNode;
        }
        if (this.id==no){
            return this;
        }
        if (this.right!=null){
            resNode=this.right.infixOrderSearch(no);
        }
        return resNode;
    }

    public HeroNode postOrderSearch(int no){
        HeroNode resNode = null;
        if (this.left!=null){
            resNode=this.left.postOrderSearch(no);
        }
        if (resNode!=null){
            return resNode;
        }
        if (this.right!=null){
            resNode=this.right.postOrderSearch(no);
        }
        if (resNode!=null){
            return resNode;
        }
        if (this.id==no){
            return this;
        }
        return resNode;
    }
}
