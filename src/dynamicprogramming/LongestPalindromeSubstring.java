package dynamicprogramming;

import java.util.Arrays;

/**
 * @author WRK
 * @date 2021/5/3 20:12
 */
public class LongestPalindromeSubstring {
    /**
     * 最长回文子串
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2){
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] chars = s.toCharArray();
        // 字串长度
        for(int l = 2; l <= len; l ++){
            // 左边界
            for(int i = 0; i < len; i++){
                int j = l + i - 1;
                if(j >= len)
                    break;
                if(chars[i] != chars[j])
                    dp[i][j] = false;
                else{
                    if(l <= 3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
