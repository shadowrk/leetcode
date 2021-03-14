package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author WRK
 * @date 2020-12-14 20:30
 */
public class ListOfDepthLCCI {
    public ListNode[] listOfDepth(TreeNode tree) {
        return levelTraversal(tree);
    }

    public ListNode[] levelTraversal(TreeNode root){
        List<ListNode> nodes = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null)
            return null;
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            TreeNode firstNode = queue.poll();
            ListNode listNode = new ListNode(firstNode.val);
            ListNode ptr = listNode;
            if(firstNode.left != null)
                queue.add(firstNode.left);
            if(firstNode.right != null)
                queue.add(firstNode.right);
            for (int i = 1; i < size; i++) {
                TreeNode node = queue.poll();
                ptr.next = new ListNode(node.val);
                ptr = ptr.next;
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            nodes.add(listNode);
        }
        return nodes.toArray(new ListNode[nodes.size()]);
    }

}
