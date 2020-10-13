package easylist;

public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        int res = 0, cur = Integer.MAX_VALUE, count = 0;
        for (int num : nums) {
            if(num > cur){
                count ++;
            }else
                count = 1;
            res = Math.max(res, count);
            cur = num;
        }

        return res;

    }
}
