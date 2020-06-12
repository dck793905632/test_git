package tree;

public class mianshiti36 {
    /*public Node treeToDoublyList(Node root) {
        if(root==null){
            return null;
        }
        Stack<Node> stack = new Stack<>();
        Node tree = root;
        Node head=null,pre=null,tail=null;
        while(!stack.empty() || tree!=null){
            if(tree!=null){
                stack.push(tree);
                tree=tree.left;
            }else{
                tree = stack.pop();
                if(pre==null){
                    head=tree;
                    pre=tree;
                    tail=tree;
                }else{
                    pre.right=tree;
                    tree.left=pre;
                    pre=tree;
                    tail=tree;
                }
                tree=tree.right;
            }
        }
        head.left=tail;
        tail.right=head;
        return head;
    }*/
}
