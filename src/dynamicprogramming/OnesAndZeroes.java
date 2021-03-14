package dynamicprogramming;

/**
 * @author WRK
 * @date 2021-01-19 13:46
 */
public class OnesAndZeroes {
    /**
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (String str : strs) {
            int[] zeroAndOneSize = calcZeroAndOneSize(str);
            for (int zeroes = m; zeroes >= zeroAndOneSize[0]; zeroes --){
                for (int ones = n; ones >= zeroAndOneSize[1]; ones --){
                    dp[zeroes][ones] = Math.max(1+dp[zeroes-zeroAndOneSize[0]][ones-zeroAndOneSize[1]], dp[zeroes][ones]);
                }
            }
        }
        return dp[m][n];


    }

    private int[] calcZeroAndOneSize(String s){
        int[] size = new int[2];
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0')
                size[0] += 1;
            else
                size[1] += 1;
        }

        return size;
    }
}
