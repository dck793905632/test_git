package tree;

public class medium106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder==null || postorder.length==0 || inorder==null || inorder.length==0 || inorder.length!=postorder.length){
            return null;
        }
        return help(postorder,0,postorder.length-1,inorder,0,inorder.length-1);
    }
    public TreeNode help(int[] postorder,int pStart,int pEnd,
                         int[] inorder,int iStart,int iEnd){
        if(pStart>pEnd || iStart>iEnd){
            return null;
        }

        TreeNode root = new TreeNode(postorder[pEnd]);
        int index=0;
        while(postorder[pEnd]!=inorder[iStart+index]){
            index++;
        }
        root.left=help(postorder,pStart,pStart+index-1,inorder,iStart,iStart+index-1);
        root.right=help(postorder,pStart+index,pEnd-1,inorder,iStart+index+1,iEnd);
        return root;

    }
}
