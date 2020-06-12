package simple;

import java.util.Stack;

public class simple234 {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while(node!=null){
            stack.push(node);
            node=node.next;
        }
        while(head!=null){
            ListNode cur = stack.pop();
            if(cur.val!=head.val){
                return false;
            }
            head=head.next;
        }
        return true;
    }
}
