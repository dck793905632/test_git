package tree;

import org.junit.Test;

public class medium236 {
    @Test
    public void test(){
        TreeNode root3 = new TreeNode(3);
        TreeNode root5 = new TreeNode(5);
        TreeNode root1 = new TreeNode(1);
        TreeNode root6 = new TreeNode(6);
        TreeNode root2 = new TreeNode(2);
        TreeNode root0 = new TreeNode(0);
        TreeNode root8 = new TreeNode(8);
        TreeNode root7 = new TreeNode(7);
        TreeNode root4 = new TreeNode(4);
        root3.left=root5;
        root3.right=root1;
        root5.left=root6;
        root5.right=root2;
        root1.left=root0;
        root1.right=root8;
        root2.left=root7;
        root2.right=root4;
        System.out.println(lowestCommonAncestor(root3,root6,root2));


    }

    //最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left!=null && right!=null){
            return root;
        }
        if(left!=null){
            return left;
        }
        if(right!=null){
            return right;
        }
        return null;
    }
}
