package easylist;

import java.util.ArrayList;
import java.util.List;

public class NaryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> preList = new ArrayList<>();
        preorder(root, preList);
        return preList;
    }

    private void preorder(Node root, List<Integer> preList) {
        if(root == null)
            return;
        preList.add(root.val);
        root.children.forEach(item -> preorder(item, preList));
    }
}
