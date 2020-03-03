package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;

    }

    private void dfs(TreeNode root, List<List<Integer>> res, int count) {
        if(root == null)
            return;
        if(res.size() < count+1)
            res.add(new ArrayList<Integer>());
        res.get(count).add(root.val);
        dfs(root.left, res, count+1);
        dfs(root.right, res, count+1);
    }

    public static void main(String[] args) {
        List<List<Integer>> test = new ArrayList<>();
        System.out.println(test.get(0));
    }
}
