package easylist;

import java.util.Arrays;

public class HouseRobber {

    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return rob(nums, 0, memo);
    }

    private int rob(int[] nums, int start, int[] memo){
        if(start >= nums.length)
            return 0;
        if(memo[start] != -1)
            return memo[start];
        int res = Math.max(nums[start] + rob(nums, start + 2, memo), rob(nums, start + 1, memo));
        memo[start] = res;

        return res;
    }
}
