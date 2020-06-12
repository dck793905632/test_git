package simple;

import org.junit.Test;

import java.util.Stack;

public class simple1290 {
    @Test
    public void test(){
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(1);
        head.next=node2;
        node2.next=node3;
        System.out.println(getDecimalValue(head));
    }
    public int getDecimalValue(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while(head!=null){
            stack.push(head);
            head=head.next;
        }
        int sum=0;
        int len=stack.size();
        for (int i = 0; i <len; i++) {
            ListNode node = stack.pop();
            if (node.val==1){
                sum+=Math.pow(2,i);
            }
        }
        return sum;
    }
}
