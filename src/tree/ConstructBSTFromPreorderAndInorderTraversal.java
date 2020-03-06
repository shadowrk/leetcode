package tree;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ConstructBSTFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> preList = new ArrayList<>();
        List<Integer> midList = new ArrayList<>();
        for (int i : preorder) {
            preList.add(i);
        }
        for (int i : inorder) {
            midList.add(i);
        }
        return buildTree(preList, midList);
//        List<Integer> preList = Arrays.stream(preorder).boxed().collect(Collectors.toList());
//        List<Integer> midList = Arrays.stream(inorder).boxed().collect(Collectors.toList());
//        if(preList.isEmpty() || midList.isEmpty())
//            return null;
//        int value = preList.get(0);
//        TreeNode root = new TreeNode(value);
//        int len = midList.indexOf(value);
//        root.left = buildTree(preList.subList(1, len+1).stream().mapToInt(Integer::valueOf).toArray(), midList.subList(0, len).stream().mapToInt(Integer::valueOf).toArray());
//        root.right = buildTree(preList.subList(len+1, preList.size()).stream().mapToInt(Integer::valueOf).toArray(), midList.subList(len+1, midList.size()).stream().mapToInt(Integer::valueOf).toArray());
//        return root;
    }

    private TreeNode buildTree(List<Integer> preList, List<Integer> midList){
        if(preList.isEmpty() || midList.isEmpty())
            return null;
        int value = preList.get(0);

        TreeNode root = new TreeNode(value);
        int len = midList.indexOf(value);
        root.left = buildTree(preList.subList(1, len+1), midList.subList(0, len));
        root.right = buildTree(preList.subList(len+1, preList.size()), midList.subList(len+1, midList.size()));
        return root;
    }
}
