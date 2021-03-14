package codinginterviews;

/**
 * @author WRK
 * @date 2021-01-27 15:01
 */
public class DeleteNode {
    /**
     * 删除链表中的一个节点
     * 两个指针prev, curr
     * prev 指向 curr 的前一个节点
     * 当curr.val = target时
     * prev.next = curr.next
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        if(head.val == val)
            return head.next;
        ListNode prev = head, curr = head.next;
        while (curr != null){
            if(curr.val == val){
                prev.next = curr.next;
                break;
            }
            curr = curr.next;
            prev = prev.next;
        }
        return head;
    }

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
}
