package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        return preOrderTraversal(root, path);
    }

    private List<Integer> preOrderTraversal(TreeNode root, List<Integer> path){
        if(root == null){
            return path;
        }
        path.add(root.val);
        preOrderTraversal(root.left, path);
        preOrderTraversal(root.right, path);
        return path;
    }

}