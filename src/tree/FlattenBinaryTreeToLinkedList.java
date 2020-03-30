package tree;

import java.util.ArrayList;
import java.util.List;

public class FlattenBinaryTreeToLinkedList {
    /**
     * 方法一
     * @param root
     */
    // public void flatten(TreeNode root) {
    //     if(root == null){
    //         return;
    //     }

    //     if(root.left != null){
    //         flatten(root.left);
    //     }
    //     if(root.right != null){
    //         flatten(root.right);
    //     }

    //     TreeNode node = root.right;
    //     root.right = root.left;
    //     root.left = null;
    //     while(root.right != null){
    //         root = root.right;
    //     }
    //     root.right = node;
        
    // }
    /**
     * 方法二
     * @param root
     */
    public void flatten(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode temp = root;
        preOrderTree(temp, list);
        if(!list.isEmpty())
            createLinkList(list, root);
        
    }

    private void createLinkList(List<Integer> list, TreeNode root) {
        root.left = null;
        root.right = null;
        root.val = list.get(0);
        for(int i=1; i<list.size(); i++){
            // root.val = list.get(i);
            root.right = new TreeNode(list.get(i));
            root = root.right;
        }
    }

    private void preOrderTree(TreeNode root, List<Integer> list) {
        if(root == null){
            return;
        }

        list.add(root.val);
        preOrderTree(root.left, list);
        preOrderTree(root.right, list);
        return;
    }

}