package tree;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        return dfs(root, sum);

    }
    private boolean dfs(TreeNode root, int sum){
        if(root == null && sum == 0)
            return true;
        if(root == null && sum != 0)
            return false;
        boolean l = false;
        boolean r = false;
        if(root.left != null && root.right == null)
            l = dfs(root.left, sum-root.val);
        else if(root.left == null && root.right != null)
            r = dfs(root.right, sum-root.val);
        else{
            l = dfs(root.left, sum-root.val);
            r = dfs(root.right, sum-root.val);
        }

        return l | r;
    }
}
