package com.atguigu.huffmancode;

import org.hamcrest.Condition;

import java.util.*;

public class HuffmanCode {
    public static void main(String[] args) {
        String content="i like like like java do you like a java";
        byte[] bytes = content.getBytes();
       /* List<Node> nodes = getNodes(bytes);
        //System.out.println(nodes);
        Node tree = createHuffmanTree(nodes);
        //tree.preOrder();
        getCodes(tree);
        //System.out.println(huffmanCodes);
        byte[] zip = zip(bytes, huffmanCodes);
        System.out.println(Arrays.toString(zip));*/
        byte[] huffmanCodeBytes = huffmanZip(bytes);
        //System.out.println(Arrays.toString(huffmanZip));

        byte[] decode = decode(huffmanCodes, huffmanCodeBytes);
        System.out.println(new String(decode));
    }

    public static byte[] decode(Map<Byte, String> huffmanCodes,byte[] huffmanBytes){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i =0 ;i<huffmanBytes.length;i++){
            byte b = huffmanBytes[i];
            boolean flag = (i==huffmanBytes.length-1);
            stringBuilder.append(byteToBitString(!flag,b));
        }

        Map<String,Byte> map = new HashMap<>();
        for (Map.Entry<Byte,String> entry:huffmanCodes.entrySet()){
            map.put(entry.getValue(),entry.getKey());
        }

        List<Byte> list = new ArrayList<>();
        for (int i=0;i<stringBuilder.length();){
            boolean flag =true;
            int count=1;
            Byte b=null;
            while (flag){
                String key = stringBuilder.substring(i, i + count);
                b = map.get(key);
                if (b==null){
                    count++;
                }else {
                    flag=false;
                }
            }
            list.add(b);

            i +=count;

        }
        byte[] bytes = new byte[list.size()];
        for (int i =0;i<list.size();i++){
            bytes[i]=list.get(i);

        }
        return bytes;
    }

    public static String byteToBitString(boolean flag,byte b){
        int temp = b;
        if (flag){
            temp |= 256;
        }
        String str = Integer.toBinaryString(temp);
        if (flag){
            return str.substring(str.length()-8);
        }else {
            return str;
        }
    }
    public static byte[] huffmanZip(byte[] bytes){
        List<Node> nodes = getNodes(bytes);
        Node tree = createHuffmanTree(nodes);
        getCodes(tree);
        byte[] zip = zip(bytes, huffmanCodes);
        return zip;
    }

    public static byte[] zip(byte[] bytes,Map<Byte,String> huffmanCodes){
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b :bytes){
            stringBuilder.append(huffmanCodes.get(b));
        }
        //System.out.println(stringBuilder);
        int len ;
        if (stringBuilder.length()%8==0){
            len=stringBuilder.length()/8;
        }else {
            len=stringBuilder.length()/8+1;
        }

        int index =0;
        byte[] huffmanCodeBytes = new byte[len];
        for (int i = 0; i < stringBuilder.length(); i+=8) {
            String substring;
            if (i+8>stringBuilder.length()){
                substring=stringBuilder.substring(i);
            }else {
                substring = stringBuilder.substring(i, i + 8);
            }
            huffmanCodeBytes[index]= (byte) Integer.parseInt(substring, 2);
            index++;
        }
        return huffmanCodeBytes;
    }


    //存放哈夫曼编码
    static Map<Byte,String> huffmanCodes = new HashMap<>();
    //拼接路径
    static StringBuilder stringBuilder = new StringBuilder();

    public static Map<Byte,String> getCodes(Node root){
        if (root==null){
            return null;
        }
        getCodes(root.left,"0",stringBuilder);
        getCodes(root.right,"1",stringBuilder);
        return huffmanCodes;
    }
    public static void getCodes(Node node,String code,StringBuilder stringBuilder){
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        stringBuilder2.append(code);

        if (node!=null){
            if (node.data==null){
                getCodes(node.left,"0",stringBuilder2);
                getCodes(node.right,"1",stringBuilder2);
            }else {
                huffmanCodes.put(node.data,stringBuilder2.toString());
            }
        }
    }

    public static List<Node> getNodes(byte[] bytes){
        List<Node> nodes = new ArrayList<>();
        Map<Byte,Integer> counts = new HashMap<>();
        for(byte value :bytes){
            Integer count = counts.get(value);
            if (count==null){
                counts.put(value,1);
            }else {
                counts.put(value,count+1);
            }
        }
        //把每个键值转为node对象
        for (Map.Entry<Byte,Integer> entry : counts.entrySet()){
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }
        return nodes;
    }
    public static Node createHuffmanTree(List<Node> nodes){
        //创建哈夫曼树
        while (nodes.size()>1){
            //从小到大排序
            Collections.sort(nodes);
            //获取前两个节点
            Node nodeLeft = nodes.get(0);
            Node nodeRight = nodes.get(1);
            //创建父节点
            Node parent = new Node(null, nodeLeft.wight + nodeRight.wight);
            parent.left=nodeLeft;
            parent.right=nodeRight;
            //删除节点
            nodes.remove(nodeLeft);
            nodes.remove(nodeRight);
            //添加节点
            nodes.add(parent);
        }
        return nodes.get(0);
    }
    public void preOrder(Node root){
        if (root!=null){
            root.preOrder();
        }else {
            System.out.println("空");
        }
    }
}

class Node implements Comparable<Node>{
    Byte data;
    int wight;
    Node left;
    Node right;

    public void preOrder(){
        System.out.println(this.toString());
        if (this.left!=null){
            this.left.preOrder();
        }
        if (this.right!=null){
            this.right.preOrder();
        }
    }
    public Node(Byte data,int wight) {
        this.data = data;
        this.wight = wight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", wight=" + wight +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.wight-o.wight;
    }
}
