package tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class simple275 {
    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root5 = new TreeNode(5);
        TreeNode root3 = new TreeNode(3);
        root.left=root2;
        root.right=root3;
        root2.right=root5;
        System.out.println(binaryTreePaths(root));


    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root==null){
            return paths;
        }
        if (root.left==null && root.right==null){
            paths.add(""+root.val);
            return paths;

        }

        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);

        for(String path : leftPaths){
            paths.add(root.val+"->"+path);
        }
        for(String path : rightPaths){
            paths.add(root.val+"->"+path);
        }
        return paths;
    }
}
