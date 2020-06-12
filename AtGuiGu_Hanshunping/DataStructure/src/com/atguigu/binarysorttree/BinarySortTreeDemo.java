package com.atguigu.binarysorttree;

public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7,3,10,12,5,1,9,2};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }

        binarySortTree.delNode(2);
        binarySortTree.delNode(5);
        binarySortTree.delNode(12);
        binarySortTree.delNode(9);
        binarySortTree.delNode(10);
        binarySortTree.delNode(1);
        binarySortTree.delNode(3);
        binarySortTree.delNode(7);
        binarySortTree.infixOrder();

    }
}

//创建树
class BinarySortTree{
    Node root;

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