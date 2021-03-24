package dynamicprogramming;

/**
 * 1312. 让字符串成为回文串的最少插入次数
 * @author WRK
 * @date 2021/3/24 19:46
 */
public class MinimumInsertionStepsToMakeAStringPalindrome {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = n-2; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                if(s.charAt(i) == s.charAt(j))
                    dp[i][j] = dp[i+1][j-1];
                else
                    dp[i][j] = Math.min(dp[i][j-1], dp[i+1][j]) + 1;
            }
        }
        return dp[0][n-1];
    }
}
