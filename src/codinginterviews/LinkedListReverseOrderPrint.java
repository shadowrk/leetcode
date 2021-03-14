package codinginterviews;

import java.util.List;
import java.util.Stack;

public class LinkedListReverseOrderPrint {
    /**
     * 从尾到头打印链表
     * 输入：head = [1,3,2]
     * 输出：[2,3,1]
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        Stack<Integer> resultStack = new Stack<>();
        ListNode p = head;
        while (p != null){
            resultStack.push(p.val);
            p = p.next;
        }
        int[] result = new int[resultStack.size()];
        int count = 0;
        while (!resultStack.isEmpty()){
            result[count] = resultStack.pop();
            count ++;
        }

        return result;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}