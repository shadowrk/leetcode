package tree;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        if(p == null || q == null)
            return false;
        if(p.val == q.val){
            boolean l_flag = isSameTree(p.left, q.left);
            boolean r_flag = isSameTree(p.right, q.right);
            if(l_flag == r_flag && l_flag)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}


