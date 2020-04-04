package tree;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        List<Integer> path  = new ArrayList<>();
        return dp(root, path);
        
    }

    private int dp(TreeNode root, List<Integer> path){
        if(root.left == null && root.right == null){
            path.add(root.val);
            int sum = 0;
            for (int i = path.size()-1; i >=0; i--) {
                sum += path.get(i) * Math.pow(10, path.size()-1-i);
            }
            if(path.size() > 0)
                path.remove(path.size()-1);
            return sum;
        }

        path.add(root.val);
        int l_sum = 0;
        int r_sum = 0;
        if(root.left != null)
            l_sum = dp(root.left, path);
        if(root.right != null)
            r_sum = dp(root.right, path);
        if(path.size() > 0)
            path.remove(path.size()-1);
        return l_sum + r_sum;
    }

}