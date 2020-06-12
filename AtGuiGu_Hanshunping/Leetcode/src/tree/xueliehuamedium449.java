package tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class xueliehuamedium449 {

    @Test
    public void test(){
        TreeNode root3 = new TreeNode(3);
        TreeNode root9 = new TreeNode(9);
        TreeNode root20 = new TreeNode(20);
        TreeNode root7 = new TreeNode(7);

        root3.left=root9;
        root3.right=root20;
        root20.left=root7;
        String serialize = serialize(root3);
        //System.out.println(serialize);
        TreeNode deserialize = deserialize(serialize);
        System.out.println(deserialize);

    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "";
        }
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        for (int i = 0; i < queue.size(); i++) {
            TreeNode node = queue.get(i);
            if (node==null){
                continue;
            }
            queue.add(node.left);
            queue.add(node.right);
        }
        while (queue.get(queue.size()-1)==null){
            queue.remove(queue.size()-1);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(queue.get(0).val);
        for (int i = 1; i < queue.size(); i++) {
            TreeNode node = queue.get(i);
            if (node==null){
                sb.append(",#");
            }else {
                sb.append(","+node.val);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0){
            return null;
        }
        String[] ss = data.split(",");
        int len = ss.length;
        ArrayList<TreeNode> queue = new ArrayList<>();
        TreeNode root = new TreeNode(Integer.parseInt(ss[0]));
        queue.add(root);
        boolean isLeft=true;
        int index=0;
        for (int i = 1; i < len; i++) {
            if (!ss[i].equals("#")){
                TreeNode node = new TreeNode(Integer.parseInt(ss[i]));
                if (isLeft){
                    queue.get(index).left=node;
                }else {
                    queue.get(index).right=node;
                }
                queue.add(node);
            }
            if (!isLeft){
                index++;
            }
            isLeft=!isLeft;
        }
        return root;
    }
}
