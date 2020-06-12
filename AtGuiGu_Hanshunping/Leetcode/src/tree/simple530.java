package tree;

import org.junit.Test;

import java.util.Stack;

public class simple530 {
    @Test
    public void test(){
        TreeNode root1 = new TreeNode(1);
        TreeNode root3 = new TreeNode(3);
        TreeNode root2 = new TreeNode(2);
        root1.right=root3;
        root3.left=root2;
        System.out.println(getMinimumDifference(root1));

    }

    public int getMinimumDifference(TreeNode root) {
        int cur=-1,min=Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null || !stack.empty()){
            if(root!=null){
                stack.push(root);
                root=root.left;
            }else{
                if(cur==-1){
                    TreeNode node = stack.pop();
                    cur = node.val;
                    root=node.right;
                }else{
                    TreeNode node1 = stack.pop();
                    int peek = node1.val;
                    int m = peek-cur;
                    cur=peek;
                    if(m<min){
                        min=m;
                    }
                    root=node1.right;
                }
            }
        }
        return min;
    }
}
