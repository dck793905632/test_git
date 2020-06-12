package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class medium513 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0;i<size;i++){
                TreeNode tree = queue.poll();
                list.add(tree.val);
                if(tree.left!=null){
                    queue.offer(tree.left);
                }
                if(tree.right!=null){
                    queue.offer(tree.right);
                }
            }
            res.add(list);
        }
        return res.get(res.size()-1).get(0);
    }
}
