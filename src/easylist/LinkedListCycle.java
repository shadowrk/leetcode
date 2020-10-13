package easylist;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode pNode = head, qNode = head;
        int pos = -1;
        while (pNode != null && qNode != null){
            pNode = pNode.next;
            qNode = qNode.next == null ? null : qNode.next.next;
            if(pNode == qNode && pNode != null)
                return true;
        }
        return false;
    }
}
