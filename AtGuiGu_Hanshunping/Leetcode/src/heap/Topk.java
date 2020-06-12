package heap;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Topk {

    @Test
    public void test(){
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(item -> -item));

        for(int i=0;i<10;i++){
            heap.offer(i);
        }
        while (!heap.isEmpty()){
            System.out.println(heap.poll());
        }
    }

    //自己维护一个小顶堆
    public int[] smallestK1(int[] arr, int k) {
        int k1=k;
        for(int i=arr.length/2-1;i>=0;i--){
            adjustHeap(arr,i,arr.length);
        }
        int temp;
        for(int j=arr.length-1;j>=0;j--){
            temp=arr[j];
            arr[j]=arr[0];
            arr[0]=temp;
            k--;
            if(k==0){
                break;
            }
            adjustHeap(arr,0,j);
        }
        int index=arr.length-1;
        int[] res = new int[k1];
        for(int j=0;j<k1;j++){
            res[j]=arr[index];
            index--;
        }
        return res;
    }
    public void adjustHeap(int[] arr,int i,int length){
        int temp = arr[i];
        for(int k=i*2+1;k<length;k=k*2+1){
            if(k+1<length && arr[k]>arr[k+1]){
                k++;
            }
            if(temp>arr[k]){
                arr[i]=arr[k];
                i=k;
            }else{
                break;
            }
        }
        arr[i]=temp;

    }


    //小顶堆
    public int[] smallestK(int[] arr, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            queue.offer(arr[i]);
        }
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i]=queue.poll();
        }
        return res;
    }
}
