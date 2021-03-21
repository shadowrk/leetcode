package tree;

/**
 * 124. Binary Tree Maximum Path Sum
 * @author WRK
 * @date 2021/3/21 10:08
 */
public class BinaryTreeMaximumPathSum {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (){}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    int maxRes = Integer.MIN_VALUE;

    /**
     * 计算二叉树中最大的路径和
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        postOrder(root);
        return maxRes;

    }

    private int postOrder(TreeNode root){
        if(root == null)
            return 0;
        int leftMax = Math.max(0, postOrder(root.left));
        int rightMax = Math.max(0, postOrder(root.right));

        maxRes = Math.max(maxRes, root.val + leftMax + rightMax);

        return Math.max(leftMax, rightMax) + root.val;
    }

}
