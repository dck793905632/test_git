package heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MegerKLists {
    Comparator ListNodeComparator=new Comparator<ListNode>(){
        public int compare(ListNode left,ListNode right){
            return left.val-right.val;
        }
    };
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0 ){
            return null;
        }
        Queue<ListNode> minHeap = new PriorityQueue<ListNode>(ListNodeComparator);
        for(ListNode node : lists){
            if(node==null){
                continue;
            }
            minHeap.offer(node);
        }
        ListNode dummp = new ListNode(-1);
        ListNode tail = dummp;
        while (!minHeap.isEmpty()){
            ListNode head = minHeap.poll();
            tail.next=head;
            tail=head;
            if(head.next!=null){
                minHeap.offer(head.next);
            }
        }
        return dummp.next;
    }
}
