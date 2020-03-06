package tree;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrderBST(root, list);
        if(list.size() == 0 || list.size() == 1)
            return true;
        for (int i = 0; i < list.size() - 1; i++) {
            if(list.get(i) >= list.get(i+1))
                return false;
        }
        return true;
    }

    private void preOrderBST(TreeNode root, List<Integer> list) {
        if(root == null)
            return;
        preOrderBST(root.left, list);
        list.add(root.val);
        preOrderBST(root.right, list);
    }
}
