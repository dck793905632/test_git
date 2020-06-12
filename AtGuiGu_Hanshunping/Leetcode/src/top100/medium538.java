package top100;

import tree.TreeNode;

import java.util.Stack;

public class medium538 {



    public TreeNode convertBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        int sum=0;
        TreeNode tree = root;
        while(!stack.isEmpty() || tree!=null){
            if(tree!=null){
                stack.push(tree);
                tree=tree.right;
            }else{
                tree = stack.pop();
                sum+=tree.val;
                tree.val=sum;
                tree=tree.left;
            }
        }
        return root;

    }
}
