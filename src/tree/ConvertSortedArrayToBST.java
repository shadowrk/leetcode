package tree;

public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        return createBST(nums, l, r);
    }

    private TreeNode createBST(int[] nums, int l, int r) {
        if(l > r)
            return null;

        int rIndex = (l+r) / 2;
        TreeNode node = new TreeNode(nums[rIndex]);
        node.left = createBST(nums, l, rIndex-1);
        node.right = createBST(nums, rIndex+1, r);
        return node;
    }
}
