package tree;

public class medium222 {
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        int ld = depth(root.left);
        int rd = depth(root.right);
        if(ld==rd){
            return (1<<ld)+countNodes(root.right);
        }else{
            return (1<<rd)+countNodes(root.left);
        }
    }

    public int depth(TreeNode root){
        int d =0;
        while(root!=null){
            d++;
            root=root.left;
        }
        return d;
    }
}
