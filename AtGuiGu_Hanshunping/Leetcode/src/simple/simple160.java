package simple;

public class simple160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=0;
        int lenB=0;
        ListNode tempA;
        ListNode tempB;
        tempA=headA;
        tempB=headB;
        while(tempA!=null){
            lenA++;
            tempA=tempA.next;
        }
        while(tempB!=null){
            lenB++;
            tempB=tempB.next;
        }
        tempA=headA;
        tempB=headB;
        while(lenA>0 && lenB>0){
            if(tempA==tempB){
                return tempA;
            }else if(lenA>lenB){
                lenA--;
                tempA=tempA.next;
            }else if(lenB>lenA){
                lenB--;
                tempB=tempB.next;
            }else{
                lenA--;
                lenB--;
                tempA=tempA.next;
                tempB=tempB.next;
            }
        }
        return null;
    }
}
