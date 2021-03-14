package codinginterviews;

import tree.TreeNode;

import java.util.*;

/**
 * @author WRK
 * @date 2021-02-02 13:59
 */
public class BinaryTreePrint {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        boolean isLeft = true;
        while (!nodeQueue.isEmpty()){
            int size = nodeQueue.size();
            List<Integer> path = new ArrayList<>();
            while (size > 0){
                TreeNode node = nodeQueue.poll();
                path.add(node.val);
                if(node.left != null)
                    nodeQueue.add(node.left);
                if(node.right != null)
                    nodeQueue.add(node.right);
                size --;
            }
            result.add(path);
        }
        for (int i = 0; i < result.size(); i++) {
            if(i % 2 != 0){
                Collections.reverse(result.get(i));
            }
        }
        return result;
    }
}
