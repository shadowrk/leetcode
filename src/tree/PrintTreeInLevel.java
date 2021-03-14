package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author WRK
 * @date 2020-12-14 20:45
 */
public class PrintTreeInLevel {
    public List<List<Integer>> levelOrder(TreeNode root) {
        return levelTraversal(root);
    }

    public List<List<Integer>> levelTraversal(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> levelItems = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelItems.add(node.val);
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }

            result.add(levelItems);
        }

        return result;
    }
}
