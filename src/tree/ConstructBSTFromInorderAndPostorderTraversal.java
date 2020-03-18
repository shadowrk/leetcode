package tree;

import java.util.ArrayList;
import java.util.List;

public class ConstructBSTFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        List<Integer> postList = new ArrayList<>();
        List<Integer> midList = new ArrayList<>();
        for (int i : postorder) {
            postList.add(i);
        }
        for (int i : inorder) {
            midList.add(i);
        }
        return buildTree(midList, postList);
    }

    private TreeNode buildTree(List<Integer> midList, List<Integer> postList) {
        if(postList.isEmpty() || midList.isEmpty())
            return null;
        int value = postList.get(postList.size() - 1);

        TreeNode root = new TreeNode(value);
        int len = midList.indexOf(value);
        root.left = buildTree(midList.subList(0, len), postList.subList(0, len));
        root.right = buildTree(midList.subList(len+1, midList.size()), postList.subList(len, midList.size()-1));
        return root;
    }
}
