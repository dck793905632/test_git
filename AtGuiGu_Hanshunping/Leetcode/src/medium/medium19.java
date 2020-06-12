package medium;

public class medium19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead=new ListNode(-1);
        ListNode pre = head;
        ListNode cur =newHead;
        newHead.next=head;
        for(int i=0;i<n;i++){
            pre=pre.next;
        }
        while(pre!=null){
            cur=cur.next;
            pre=pre.next;
        }
        cur.next=cur.next.next;
        return newHead.next;
    }
}
