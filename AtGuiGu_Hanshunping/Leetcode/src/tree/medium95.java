package tree;

import java.util.ArrayList;
import java.util.List;

public class medium95 {
    public List<TreeNode> generateTrees(int n) {
        if(n==0){
            return new ArrayList<TreeNode>();
        }
        return createTree(1,n);
    }
    public List<TreeNode> createTree(int start,int end){
        List<TreeNode> trees = new ArrayList<>();
        if(start>end){
            trees.add(null);
            return trees;
        }

        for(int i=start;i<=end;i++){
            List<TreeNode> left = createTree(start,i-1);
            List<TreeNode> right = createTree(i+1,end);

            for(TreeNode l :left){
                for(TreeNode r :right){
                    TreeNode root  = new TreeNode(i);
                    root.left=l;
                    root.right=r;
                    trees.add(root);
                }
            }
        }
        return trees;
    }
}
