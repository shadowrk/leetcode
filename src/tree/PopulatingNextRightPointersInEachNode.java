package tree;

import java.util.LinkedList;
import java.util.List;

public class PopulatingNextRightPointersInEachNode {
    /**
     * 方法一，时间复杂度高
     * @param root
     * @return
     */
    // public Node connect(Node root) {
    //     List<Node> queue = new LinkedList<>();
    //     if(root == null || root.left == null) return root;
    //     queue.add(root.left);
    //     queue.add(root.right);
    //     while(!queue.isEmpty()){
    //         int len = queue.size();
    //         for (int i = 0; i < queue.size()-1; i++) {
    //             queue.get(i).next = queue.get(i+1);
    //         }
    //         for(int i = 0; i < len; i++){
    //             Node temp = queue.remove(0);
    //             if(temp.left != null)
    //                 queue.add(temp.left);
    //             if(temp.right != null)
    //                 queue.add(temp.right);
    //         }
    //     }
    //     return root;
    // }
    /**
     * 方法二，时间复杂度更低
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if(root == null || root.left == null) return root;
        root.left.next = root.right;
        //dep 用来标记每层的第一个节点
        Node dep = root.left;
        if(dep.left == null) return root;
        //currentNode 用来标记当前的节点
        Node currentNode = dep.left;
        while(dep != null){
            Node temp = dep;
            currentNode.next = temp.right;
            currentNode = currentNode.next;
            temp = temp.next;
            while(temp != null){
                if(temp.left != null){
                    currentNode.next = temp.left;
                    currentNode = currentNode.next;
                }
                if(temp.right != null){
                    currentNode.next = temp.right;
                    currentNode = currentNode.next;
                }
                temp = temp.next;
            }
            dep = dep.left;
            currentNode = dep;
            if(currentNode == null) break;
        }
        return root;
    }
}