package common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author WRK
 * @date 2020-12-16 17:35
 */
public class MergekSortedLists {
    /**
     * 归并
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> listNodeQueue = new LinkedList<>();
        for (ListNode list : lists) {
            listNodeQueue.add(list);
        }
        while (listNodeQueue.size() > 1){
            ListNode listNode1 = listNodeQueue.poll();
            ListNode listNode2 = listNodeQueue.poll();
            ListNode merge = merge(listNode1, listNode2);
            listNodeQueue.add(merge);
        }
        return listNodeQueue.poll();
    }

    private ListNode merge(ListNode list1, ListNode list2){
        ListNode node1 = list1;
        ListNode node2 = list2;
        ListNode mergeList = new ListNode();
        ListNode node3 = mergeList;
        if(node1 == null)
            return node2;
        if(node2 == null)
            return node1;
        while (node1 != null && node2 != null){
            if(node1.val >= node2.val){
                node3.val = node2.val;
                node3.next = new ListNode();
                node3 = node3.next;
                node2 = node2.next;
            }else{
                node3.val = node1.val;
                node3.next = new ListNode();
                node3 = node3.next;
                node1 = node1.next;
            }
        }
        if(node1 != null && node2 == null){
            node3.val = node1.val;
            node3.next = node1.next;
        }else if(node1 == null && node2 != null){
            node3.val = node2.val;
            node3.next = node2.next;
        }else{
            node3 = null;
        }

        return mergeList;

    }
}
