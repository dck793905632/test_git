package tree;

public class simple226 {
    public TreeNode invertTree(TreeNode root) {
        if(root==null||(root.left==null&&root.right==null)){
            return root;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left=invertTree(right);
        root.right=invertTree(left);
        return root;
    }
}
