package tree;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInBST {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> ele = new ArrayList<>();
        ele = traversal(root, ele);
        return ele.get(k-1);
        
    }

    private List<Integer> traversal(TreeNode root, List<Integer> ele){
        if(root == null) return ele;
        traversal(root.left, ele);
        ele.add(root.val);
        traversal(root.right, ele);

        return ele;
    }

}