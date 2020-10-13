package easylist;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode nodeA = headA, nodeB = headB;
        while (nodeA != null){
            lenA ++;
            nodeA = nodeA.next;
        }
        while (nodeB != null){
            lenB ++;
            nodeB = nodeB.next;
        }
        nodeA = headA;
        nodeB = headB;
        if(lenA > lenB){
            int diff = lenA - lenB;
            while (diff > 0){
                nodeA = nodeA.next;
                diff --;
            }
        }else{
            int diff = lenB - lenA;
            while (diff > 0){
                nodeB = nodeB.next;
                diff --;
            }
        }
        while (nodeA != nodeB && nodeA != null){
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }

        return nodeA;

    }
}
