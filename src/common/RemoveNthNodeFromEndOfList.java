package common;

/**
 * @author WRK
 * @date 2020-12-15 17:24
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode quick = head, slow=head, current=head;

        for (int i = 0; i < n-1; i++) {
            quick = quick.next;
        }
        if(quick == null)
            return null;
        if(quick.next == null)
            return current.next;
        quick = quick.next;
        current = current.next;
        while (quick.next!=null){
            quick = quick.next;
            current = current.next;
            slow = slow.next;
        }
        slow.next = current.next;

        return head;

    }

    public static void main(String[] args) {
        RemoveNthNodeFromEndOfList test = new RemoveNthNodeFromEndOfList();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        ListNode node = test.removeNthFromEnd(node1, 2);
        while (node!= null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
