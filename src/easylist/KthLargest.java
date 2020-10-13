package easylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KthLargest {
    int k;
    int[] nums;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
    }

    public int add(int val) {
        int[] temp = Arrays.copyOf(nums, nums.length+1);
        temp[temp.length-1] = val;
        Arrays.sort(temp);
        nums = temp;
        return temp[nums.length-k];
    }

}
