package tree;

public class SymmetricTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return help_fun(root.left, root.right);
    }

    private boolean help_fun(TreeNode root1, TreeNode root2) {

        if(root1 == null && root2 == null)
            return true;
        if(root1 == null || root2 == null)
            return false;
        if(root1.val == root2.val){
            return help_fun(root1.left, root2.right) && help_fun(root1.right, root2.left);
        }
        return false;
    }
}
