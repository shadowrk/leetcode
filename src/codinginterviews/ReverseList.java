package codinginterviews;

/**
 * @author WRK
 * @date 2021-01-27 15:59
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if(head ==  null || head.next == null)
            return head;

        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}
