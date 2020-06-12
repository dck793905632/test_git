package top100;

import java.util.HashSet;
import java.util.Set;

public class medium142 {
    public ListNode detectCycle(ListNode head) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        ListNode tmp = head;
        ListNode res = null;
        while(tmp.next!=null){
            if(!set.contains(tmp)){
                set.add(tmp);
                tmp=tmp.next;
            }else{
                res = tmp;
                break;
            }
        }
        return res;
    }
}
