package common;

/**
 * @author WRK
 * @date 2020-12-17 19:44
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;

    }

}
