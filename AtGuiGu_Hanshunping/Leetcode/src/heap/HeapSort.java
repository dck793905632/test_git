package heap;

import org.junit.Test;

import java.util.Arrays;

public class HeapSort {
    @Test
    public void test(){
        int[] arr = new int[]{3,2,1,5,6,4};
        heapSort(arr);
        //System.out.println(Arrays.toString(arr));
    }

    public void heapSort(int[] arr){
        int temp=0;
        for(int i=arr.length/2-1;i>=0;i--){
            adjustHeap(arr,i,arr.length);
            System.out.println(Arrays.toString(arr));
        }

        for(int j=arr.length-1;j>=0;j--){
            temp=arr[0];
            arr[0]=arr[j];
            arr[j]=temp;
            adjustHeap(arr,0,j);
        }

    }
    //用数组表示二叉树，左子节点=k*2+1,右子节点=k*2+2。
    //arr原数组，i要调整的非叶子节点，length要调整的数组长度
    public void adjustHeap(int[] arr ,int i,int length){
        int temp = arr[i];
        for(int k=i*2+1;k<length;k=k*2+1){
            if(k+1<length && arr[k]<arr[k+1]){
                k++;
            }
            if(temp<arr[k]){
                arr[i]=arr[k];
                i=k;
            }else {
                break;
            }
        }
        arr[i]=temp;
    }
}
