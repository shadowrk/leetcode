package tree;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        int depth = 0;
        return maxDepth(root, depth);
    }
    private int maxDepth(TreeNode root, int depth){
        if(root == null)
            return depth;

        int depth1 = maxDepth(root.left, depth + 1);
        int depth2 = maxDepth(root.right, depth + 1);
        return Math.max(depth1, depth2);

    }
}
