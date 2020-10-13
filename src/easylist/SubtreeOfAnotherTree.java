package easylist;

public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null)
            return false;
        if(isSameTree(s, t))
            return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        if(p == null || q == null)
            return false;
        if(p.val != q.val)
            return false;
//        if(p.val == q.val){
//            boolean l_flag = isSameTree(p.left, q.left);
//            boolean r_flag = isSameTree(p.right, q.right);
//            if(l_flag == r_flag && l_flag)
//                return true;
//        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
