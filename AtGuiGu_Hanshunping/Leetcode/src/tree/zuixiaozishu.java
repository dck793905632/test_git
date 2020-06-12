package tree;

import org.junit.Test;

public class zuixiaozishu {
    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root5 = new TreeNode(5);
        TreeNode root3 = new TreeNode(3);
        root.left=root2;
        root.right=root3;
        root2.right=root5;
    }

    public TreeNode subTree=null;
    public int subtreeSum=Integer.MAX_VALUE;
    public TreeNode findSubtree(TreeNode root){
        helper(root);
        return subTree;
    }

    public int helper(TreeNode root){
        if(root==null){
            return 0;
        }

        int sum=helper(root.left)+helper(root.right)+root.val;

        if(sum<subtreeSum){
            subtreeSum=sum;
            subTree=root;
        }
        return sum;

    }
}
