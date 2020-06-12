package tree;

public class simple108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0){
            return null;
        }else{
            return creatTree(nums,0,nums.length-1);
        }

    }
    public TreeNode creatTree(int[] nums,int l,int r){
        if(l>r){
            return null;
        }
        int mid = (l+r)/2;
        TreeNode tree = new TreeNode(nums[mid]);
        tree.left=creatTree(nums,l,mid-1);
        tree.right=creatTree(nums,mid+1,r);
        return tree;
    }
}
