package easylist;

public class TrimABinarySearchTree {
    public TreeNode trimBST(TreeNode root, int L, int R) {
//        if(root == null)
//            return null;
//        if(root.val < L)
//            return trimBST(root.right, L, R);
//        if(root.val > R)
//            return trimBST(root.left, L, R);
//        TreeNode newRoot = new TreeNode(root.val, null, null);
//        TreeNode newTree = newRoot;
//        trimBST(root.left, newTree.left, L, R);
//        trimBST(root.right, newTree.right, L, R);
        TreeNode newRoot = null;
        return trimBST(root, newRoot, L, R);
    }

    private TreeNode trimBST(TreeNode root, TreeNode newRoot, int L, int R){
        if(root == null)
            return null;

        if(root.val > R){
            newRoot = trimBST(root.left, newRoot, L, R);
        }else if(root.val < L){
            newRoot = trimBST(root.right, newRoot, L, R);
        }else{
            newRoot = new TreeNode(root.val, null, null);
            newRoot.left = trimBST(root.left, newRoot.left, L, R);
            newRoot.right = trimBST(root.right, newRoot.right, L, R);
        }
        return newRoot;
    }
}
