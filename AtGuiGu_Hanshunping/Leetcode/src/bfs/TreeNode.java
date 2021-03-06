package bfs;

public class TreeNode {
    int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode(int x) { val = x; }

    /*@Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }*/

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
