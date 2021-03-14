package codinginterviews;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 复杂链表的复制
 * @author WRK
 * @date 2021/3/14 19:12
 */
public class ComplexLinkedList {
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        Map<Node, Node> nodeMapping = new HashMap<>();
        Node p = head;
        Node copyHead = new Node(p.val);
        Node q = copyHead;
        nodeMapping.put(p, q);
        p = p.next;
        while (p != null){
            Node temp = new Node(p.val);
            nodeMapping.put(p, temp);
            q.next = temp;
            q = q.next;
            p = p.next;
        }
        p = head;
        q = copyHead;
        while (p != null){
            if(p.random != null){
                q.random = nodeMapping.get(p.random);
            }
            p = p.next;
            q = q.next;
        }
        return copyHead;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
