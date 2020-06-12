package tree;

import java.util.Stack;

public class simple938 {
    public int rangeSumBST(TreeNode root, int L, int R) {
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (root.val >= L && root.val <= R) {
                    sum += root.val;
                }
                root = root.right;
            }
        }
        return sum;
    }
}
