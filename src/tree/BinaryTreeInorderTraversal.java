package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(root, res);
        return res;
    }

    private void traversal(TreeNode root, List<Integer> res) {
        if(root == null)
            return;
        traversal(root.left, res);
        res.add(root.val);
        traversal(root.right, res);
    }
}
