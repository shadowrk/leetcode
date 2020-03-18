package tree;

public class BalancedBinaryTree {
    int maxHeightDiff = 0;

    public boolean isBalanced(TreeNode root) {

        int height = traversTree(root);

        if (maxHeightDiff > 1) {
            return false;
        } else {
            return true;
        }
    }
    public int traversTree(TreeNode node) {

        if (node == null) {
            return 1;
        }

        int left = traversTree(node.left);
        int right = traversTree(node.right);

        if (Math.abs(left - right) > maxHeightDiff) {
            maxHeightDiff = Math.abs(left - right);
        }

        if (left > right) {
            return left + 1;
        } else {
            return right + 1;
        }
    }
}
