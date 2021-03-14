package codinginterviews;

/**
 * @author WRK
 * @date 2021-01-27 13:49
 */
public class CutTheRope {
    /**
     * n: 绳子长度， m: 剪成m段
     * 状态：绳子长度， 剪的段数
     * for i in n:
     *    for j in m:
     *        dp[n][m] = max(m 段，每段长度的积)
     * 优化dp: dp[i] = 长度为i的绳子剪断后的最大乘积
     * dp[i] = max(dp[i], max(j*dp[i-j], j*(i-j)))
     * @param n
     * @return
     */
    public int cuttingRope(int n) {

       int[] dp = new int[n+1];
       dp[2] = 1;
        for (int i = 3; i < n+1; i++) {
            for (int j = 2; j < i; j++){
                dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
            }
        }

        return dp[n];


    }

}
