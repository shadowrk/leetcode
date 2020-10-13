package easylist;

public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null)
            return null;
        if(t1 != null && t2 != null)
            t1.val += t2.val;
        else if(t1 == null && t2 != null)
            t1 = new TreeNode(t2.val, null, null);

        t1.left = t2 != null ? mergeTrees(t1.left, t2.left) : t1.left;
        t1.right = t2 != null ? mergeTrees(t1.right, t2.right) : t1.right;


        return t1;

    }



}
