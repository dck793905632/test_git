package simple;

public class simple876 {
    public ListNode middleNode(ListNode head) {
        if(head==null){
            return null;
        }
        int l = len(head);

        int l1=l/2;
        int count=0;
        while(head!=null){
            if(l1==count){
                break;
            }
            count++;
            head=head.next;
        }
        return head;
    }
    public int len(ListNode head){
        int count=0;
        while(head!=null){
            count++;
            head=head.next;
        }
        return count;
    }
}
