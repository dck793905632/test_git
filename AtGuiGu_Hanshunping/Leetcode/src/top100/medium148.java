package top100;

public class medium148 {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode fast=head.next;
        ListNode slow=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next=null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode tempHead=new ListNode(-1);
        ListNode res = tempHead;
        while(left!=null && right!=null){
            if(left.val<right.val){
                tempHead.next=left;
                left=left.next;
            }else{
                tempHead.next=right;
                right=right.next;
            }
            tempHead=tempHead.next;
        }
        tempHead.next=left==null? right : left;
        return res.next;
    }
}
