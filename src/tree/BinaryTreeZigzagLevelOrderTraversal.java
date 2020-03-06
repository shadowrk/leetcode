package tree;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        boolean flag = true;
//        dfs(root, res, 0, flag);
        bfs(root, res, 0);
        return res;

    }

    private void bfs(TreeNode root, List<List<Integer>> res, int count) {
        if(root == null)
            return;
        boolean flag = true;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerFirst(root);
        while(!queue.isEmpty()){
            List<TreeNode> nodes = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            while (!queue.isEmpty()){
                TreeNode node = queue.pollFirst();
                nodes.add(node);
                list.add(node.val);
            }
            if(!flag)
                Collections.reverse(list);
            res.add(list);
            flag = !flag;
            for (TreeNode node : nodes) {
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            nodes.clear();
        }
    }

}
