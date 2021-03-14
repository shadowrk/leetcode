package codinginterviews;

/**
 * @author WRK
 * @date 2021-01-27 15:46
 */
public class ReciprocalK {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode prev = head;
        ListNode curr = head;
        while (k > 0 && curr != null){
            curr = curr.next;
            k --;
        }
        while (curr != null){
            curr = curr.next;
            prev = prev.next;
        }

        return prev;

    }
}
