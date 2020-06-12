package com.atguigu.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13,7,8,3,29,6,1};
        Node huffmanTree = createHuffmanTree(arr);
        preOrder(huffmanTree);
    }

    public static void preOrder(Node root){
        if (root!=null){
            root.preOrder();
        }else {
            System.out.println("空");
        }
    }
    public static Node createHuffmanTree(int[] arr){
        List<Node> nodes = new ArrayList<>();
        for (int value:arr) {
            nodes.add(new Node(value));
        }

        while (nodes.size()>1){
            Collections.sort(nodes);
            //System.out.println(nodes);

            //1取出最小两个节点
            Node nodeLeft = nodes.get(0);
            Node nodeRight = nodes.get(1);

            //2生成父节点
            Node parent = new Node(nodeLeft.value+nodeRight.value);
            parent.left=nodeLeft;
            parent.right=nodeRight;

            //3移除前两个节点
            nodes.remove(nodeLeft);
            nodes.remove(nodeRight);
            //4将父节点加入list
            nodes.add(parent);
        }
        return nodes.get(0);

    }
}
class Node implements Comparable<Node>{
     int value;
     Node left;
     Node right;

    public void preOrder(){
        System.out.println(this.value);
        if (this.left!=null){
            this.left.preOrder();
        }
        if (this.right!=null){
            this.right.preOrder();
        }
    }
    public Node(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return this.value-o.value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
