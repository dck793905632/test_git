package heap;

public class medium215 {
    public int findKthLargest(int[] nums, int k) {
        int temp;
        for(int i=nums.length/2-1;i>=0;i--){
            adjustHeap(nums,i,nums.length);
        }
        for(int j=nums.length-1;j>=0;j--){
            temp=nums[0];
            nums[0]=nums[j];
            nums[j]=temp;
            k--;
            if(k==0){
                return nums[j];
            }
            adjustHeap(nums,0,j);
        }
        return -1;
    }
    public void adjustHeap(int[] nums,int i,int length){
        int temp=nums[i];
        for(int k=i*2+1;k<length;k=k*2+1){
            if(k+1<length && nums[k]<nums[k+1]){
                k++;
            }
            if(temp<nums[k]){
                nums[i]=nums[k];
                i=k;
            }else{
                break;
            }
        }
        nums[i]=temp;
    }
}
