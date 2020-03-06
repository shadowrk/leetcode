package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res, 0);
        Collections.reverse(res);
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
}
