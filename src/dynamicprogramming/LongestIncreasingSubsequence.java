package dynamicprogramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length]; //dp[i] -> 以nums[i]结尾的最长递增子序列的长度
        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int item : dp) {
            res = Math.max(res, item);
        }

        return res;

    }
}
