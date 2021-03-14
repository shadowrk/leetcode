package codinginterviews;

import java.util.List;

/**
 * @author WRK
 * @date 2021-01-27 16:13
 */
public class MergeList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        if(p2 == null)
            return p1;
        if(p1 == null)
            return p2;
        ListNode p3 = null;
        if(p1.val <= p2.val){
            p3 = new ListNode(p1.val);
            p1 = p1.next;
        }else{
            p3 = new ListNode(p2.val);
            p2 = p2.next;
        }
        ListNode l3 = p3;
        while (p1 != null && p2 != null){
            if(p1.val > p2.val){
                p3.next = new ListNode(p2.val);
                p3 = p3.next;
                p2 = p2.next;
            }else{
                p3.next = new ListNode(p1.val);
                p3 = p3.next;
                p1 = p1.next;
            }
        }
        if(p1 != null && p2 == null){
            p3.next = p1;
        }else if(p1 == null && p2 != null){
            p3.next = p2;
        }

        return l3;
    }
}
