package dynamicprogramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    /**
     * 最长递增子序列
     * 输入: [10,9,2,5,3,7,101,18]
     * 输出: 4
     * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0)
            return 0;
        // dp[i] 表示以nums[i]结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];

        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int maxdp = 0;
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]){
                    maxdp = Math.max(maxdp, dp[j]);
                }
            }
            dp[i] = maxdp + 1;
        }
        int result = 0;
        for (int i = 0; i < dp.length; i++) {
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}