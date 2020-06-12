package tree;

public class simple101 {
    public boolean isSymmetric(TreeNode root) {
        return ism(root,root);
    }
    boolean ism(TreeNode root1,TreeNode root2){
        if(root1==null && root2==null){
            return true;
        }
        if(root1==null || root2==null){
            return false;
        }
        if(root1!=null && root2!=null && root1.val==root2.val){
            return ism(root1.left,root2.right) && ism(root1.right,root2.left);
        }
        return false;
    }
}
