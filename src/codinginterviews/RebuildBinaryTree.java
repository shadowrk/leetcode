package codinginterviews;

import tree.TreeNode;

import java.util.Arrays;

public class RebuildBinaryTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0)
            return null;

        TreeNode node = new TreeNode(preorder[0]);
        int leftSize = 0;
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == preorder[0])
                break;
            leftSize ++;
        }
        int[] leftPre = Arrays.copyOfRange(preorder, 1, leftSize+1);
        int[] leftIn = Arrays.copyOfRange(inorder, 0, leftSize);
        node.left = buildTree(leftPre, leftIn);

        int[] rightPre = Arrays.copyOfRange(preorder, leftSize+1, preorder.length);
        int[] rightIn = Arrays.copyOfRange(inorder, leftSize+1, inorder.length);
        node.right = buildTree(rightPre, rightIn);
        return node;

    }

}
