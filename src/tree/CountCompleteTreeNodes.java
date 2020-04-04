package tree;

public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        TreeNode l_root = root;
        TreeNode r_root = root;
        int l_height = 0;
        int r_height = 0;
        while(l_root != null){
            l_height ++;
            l_root = l_root.left;
        }
        while(r_root != null){
            r_height ++;
            r_root = r_root.right;
        }
        if(l_height == r_height){
            return (int)Math.pow(2, l_height) - 1;
        }

        return countNodes(root.left)+countNodes(root.right)+1;
        
    }


}