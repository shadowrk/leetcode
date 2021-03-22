package dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 354. 俄罗斯套娃信封问题
 * @author WRK
 * @date 2021/3/22 19:29
 */
public class RussianDollEnvelopes {

    /**
     * 信封嵌套问题实际上是最长递增子序列问题上升到
     * 二维，需要按照一定规则排序后就可以转化为一维的
     * 最长递增子序列问题。
     * 解法类似最长递增子序列问题
     * 1. 按照宽度递增排序
     * 2. 宽度相同时按照高度降序排序
     * 3. 求高度的最长递增子序列
     * 如果宽度相同时，不同高度的信封是没办法进行嵌套的
     * 所以按照高度的降序排序，能够保证宽度相同的情况下，
     * 只有一个高度的信封能够被选中
     * @param envelopes
     * @return
     */
    public int maxEnvelopes(int[][] envelopes) {

        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0])
                    return o1[0] - o2[0];
                else
                    return o2[1] - o1[1];
            }
        });

        int[] dp = new int[envelopes.length + 1];
        dp[0] = 1;
        for (int i = 0; i < envelopes.length; i++) {
            int maxEnvelope = 0;
            for(int j = 0; j < i; j++){
                if(envelopes[i][1] > envelopes[j][1]){
                    maxEnvelope = Math.max(maxEnvelope, dp[j]);
                }
            }
            dp[i] = maxEnvelope + 1;
        }
        int result = 0;
        for (int i = 0; i < dp.length; i++) {
            result = Math.max(result, dp[i]);
        }
        return result;

    }
}
