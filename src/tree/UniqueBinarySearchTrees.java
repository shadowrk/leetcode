package tree;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] nums = new int[n+1];
        nums[0] = 1;
        for (int i = 1; i <= n; i++) {
            if(i < 3)
                nums[i] = i;
            else{
                for(int j = 1; j<=i; j++){
                    nums[i] += nums[j-1] * nums[i-j];
                }
            }
        }
        return nums[n];

    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees trees = new UniqueBinarySearchTrees();
        System.out.println(trees.numTrees(3));
    }



}
