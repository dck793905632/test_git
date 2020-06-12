package tree;

import org.junit.Test;

import java.util.Stack;

public class medium144 {
    @Test
    public void test() {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        TreeNode root6 = new TreeNode(6);
        root1.left=root2;
        root1.right=root5;
        root2.left=root3;
        root2.right=root4;
        root5.right=root6;
        flatten(root1);
        System.out.println(root1);
    }
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        TreeNode tree=root,pre=null,head=null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(tree);
        while(!stack.empty()){
            TreeNode node = stack.pop();
            TreeNode node1 = new TreeNode(node.val);
            if(pre==null){
                head=node1;
                pre=node1;
            }else{
                pre.right=node1;
                pre=node1;
            }
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
        root.right=head.right;
        root.left=null;
    }
}
