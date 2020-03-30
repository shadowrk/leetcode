package tree;

import java.util.LinkedList;
import java.util.List;

public class PopulatingNextRightPointersInEachNodeII {
    public Node connect(Node root) {
        List<Node> queue = new LinkedList<>();
        if(root == null) return root;
        queue.add(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            // for (int i = 0; i < queue.size()-1; i++) {
            //     queue.get(i).next = queue.get(i+1);
            // }
            for(int i = 0; i < len; i++){
                Node temp = queue.remove(0);
                if(i < len-1)
                    temp.next = queue.get(0);
                if(temp.left != null)
                    queue.add(temp.left);
                if(temp.right != null)
                    queue.add(temp.right);
            }
        }
        return root;
    }
}