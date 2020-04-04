package tree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeIterator {

    class BSTIterator {
        private List<Integer> list;

        public BSTIterator(TreeNode root) {
            list = new ArrayList<>();
            list = inOrderTraversal(root, list);
        }
        
        /** @return the next smallest number */
        public int next() {
            int result = this.list.get(0);
            this.list.remove(0);
            return result;
        }
        
        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !this.list.isEmpty();
            
        }

        private List<Integer> inOrderTraversal(TreeNode root, List<Integer> path){
            if(root == null){
                return path;
            }
            inOrderTraversal(root.left, path);
            path.add(root.val);
            inOrderTraversal(root.right, path);
            
            return path;
        }
    }

}