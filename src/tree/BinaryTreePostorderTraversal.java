package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        return postorderTraversal(root, path);
        
    }

    private List<Integer> postorderTraversal(TreeNode root, List<Integer> path){
        if(root == null){
            return path;
        }
        postorderTraversal(root.left, path);
        postorderTraversal(root.right, path);
        path.add(root.val);
        return path;
    }

}