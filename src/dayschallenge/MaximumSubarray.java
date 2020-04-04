package dayschallenge;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = nums[0];

        for(int i=1; i< nums.length; i++){
            dp[i] = Math.max(nums[i], dp[i-1]+nums[i]);
        }

        int result = Integer.MIN_VALUE;
        for (int i : dp) {
            result = Math.max(i, result);
        }

        return result;
    }
    public static void main(String[] args) {
        int[] nums = new int[] {
            -2, 1, -3, 4, -1, 2, 1, -5, 4
        };
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        System.out.println(maximumSubarray.maxSubArray(nums));
    }

}