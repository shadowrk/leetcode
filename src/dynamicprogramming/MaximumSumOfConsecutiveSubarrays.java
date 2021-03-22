package dynamicprogramming;

import java.util.Arrays;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 * @author WRK
 * @date 2021/3/22 19:57
 */
public class MaximumSumOfConsecutiveSubarrays {
    /**
     * 状态：以nums[i]为结尾的最大连续子数组
     * 选择：nums[i]加入连续子数组或者以nums[i]开始新的连续子数组
     * base case: nums.length = 0  return 0
     * dp[i]: 以nums[i]为结尾的"最大连续子数组和"
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if(nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }
        return Arrays.stream(dp)
                .max()
                .getAsInt();

    }
}
