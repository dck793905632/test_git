package tree;

import org.junit.Test;

import java.util.Stack;

public class medium98 {
    @Test
    public void test(){
        TreeNode root2 = new TreeNode(2);
        TreeNode root1 = new TreeNode(1);
        TreeNode root3 = new TreeNode(3);
        root2.left=root1;
        root2.right=root3;
        System.out.println(-Double.MAX_VALUE);
        System.out.println(isValidBST(root2));
    }
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        double min=-Double.MAX_VALUE;
        TreeNode tree = root;
        while(tree!=null || !stack.empty()){
            if(tree!=null){
                stack.push(tree);
                tree=tree.left;
            }else{
                tree = stack.pop();
                if(min<tree.val){
                    min=tree.val;
                }else{
                    return false;
                }
                tree=tree.right;
            }
        }
        return true;
    }
}
