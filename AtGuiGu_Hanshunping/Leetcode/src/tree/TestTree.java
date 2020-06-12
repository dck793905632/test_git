package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TestTree {

    //二叉树前序遍历非递归实现
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            TreeNode node = stack.pop();
            list.add(node.val);
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
        return list;
    }
    //二叉树的非递归中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tree = root;
        while(!stack.empty()||tree!=null){
            if(tree!=null){
                stack.push(tree);
                tree=tree.left;
            }else{
                tree = stack.pop();
                list.add(tree.val);
                tree=tree.right;
            }
        }
        return list;
    }


    //二叉树后序遍历非递归实现1
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list =new ArrayList<>();
        if (root==null){
            return list;
        }
        Stack<TreeNode> stack =new Stack<>();
        stack.push(root);
        TreeNode node ;
        while (!stack.isEmpty()){
            node = stack.pop();
            list.add(0,node.val);
            if (node.left!=null){
                stack.push(node.left);
            }
            if (node.right!=null){
                stack.push(node.right);
            }
        }
        return list;
    }


}
