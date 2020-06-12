package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class medium199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode tree = queue.poll();
                if(tree.left!=null){
                    queue.offer(tree.left);
                }
                if(tree.right!=null){
                    queue.offer(tree.right);
                }
                if(i==size-1){
                    res.add(tree.val);
                }
            }
        }
        return res;
    }
}
