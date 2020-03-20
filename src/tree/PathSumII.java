package tree;

import java.util.*;
import java.util.Queue;
import java.util.stream.Collectors;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, sum, paths, path);
        return paths;
    }

    private void dfs(TreeNode root, int sum, List<List<Integer>> paths, List<Integer> path){
        if(root == null)
            return;
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(path.size() > 0 && sum-root.val == 0){
                List<Integer> temp = new ArrayList<>();
                path.forEach(x -> temp.add(x));
                paths.add(temp);
            }
            path.remove(path.size()-1);
            return;
        }
//        if(root == null && sum != 0){
//            if(path.size() > 0){
//                path.remove(path.size()-1);
//            }
//            return;
//        }
        dfs(root.left, sum-root.val, paths, path);
        dfs(root.right, sum-root.val, paths, path);
        path.remove(path.size()-1);
        return;
    }

}
