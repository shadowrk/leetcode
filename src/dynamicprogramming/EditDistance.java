package dynamicprogramming;

import java.util.Arrays;

/**
 * 72. 编辑距离
 * @author WRK
 * @date 2021/3/23 19:26
 */
public class EditDistance {
    /**
     * 1. dp[i][j] = word1[0...i]与word2[0...j]的最小编辑距离
     * 2. base case: dp[0][j] = j, dp[i][0] = i
     * 3. 状态转移方程:
     * word1[i] == word2[j]: dp[i][j] = dp[i-1][j-1]
     * word1[i] != word2[j]: dp[i][j] = min(dp[i][j-1] + 1, dp[i - 1][j] + 1, dp[i-1][j-1]+1)
     * @param word1
     * @param word2
     * @return
     * 
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i][j-1] + 1, Math.min(dp[i-1][j] + 1, dp[i-1][j-1] + 1));
                }
            }
        }
        return dp[m][n];
    }
}
