package dynamicprogramming;

import java.util.Arrays;

/**
 * 1143. 最长公共子序列
 * @author WRK
 * @date 2021/3/23 18:48
 */
public class LongestCommonSubsequence {
    /**
     * 1. dp[i][j]: text1前i个字符与text2前j个字符
     * 的最长公共子序列
     * 2. base case: dp[0][] = 0, dp[][0] = 0
     * 3. 状态转移方程：
     * text1[i] == text2[j]: dp[i][j] = dp[i-1][j-1] + 1
     * text1[i] != text2[j]:
     * dp[i][j] = max(dp[i][j-1], dp[i-1][j])
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        Arrays.fill(dp[0], 0);
        Arrays.stream(dp)
                .forEach(item -> item[0]=0);
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }

}
