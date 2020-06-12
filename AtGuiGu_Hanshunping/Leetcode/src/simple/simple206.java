package simple;

public class simple206 {
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        ListNode resverse=null;
        ListNode cur=head;
        ListNode next = null;
        while(cur!=null){
            next=cur.next;
            cur.next=resverse;
            resverse=cur;
            cur=next;

        }
        return resverse;
    }
}
