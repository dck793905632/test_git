package tree;

public class medium105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || preorder.length==0 || inorder==null || inorder.length==0 || inorder.length!=preorder.length){
            return null;
        }
        return help(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    public TreeNode help(int[] preorder,int pStart,int pEnd,
                         int[] inorder,int iStart,int iEnd){
        //递归出口
        if(pStart>pEnd || iStart>iEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[pStart]);
        int index=0;
        while(preorder[pStart]!=inorder[iStart+index]){
            index++;
        }
        root.left=help(preorder,pStart+1,pStart+index,inorder,iStart,iStart+index-1);
        root.right=help(preorder,pStart+index+1,pEnd,inorder,iStart+index+1,iEnd);
        return root;
    }
}
