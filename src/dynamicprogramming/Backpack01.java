package dynamicprogramming;

import java.util.Arrays;

/**
 * 01 背包问题
 */
public class Backpack01 {
    /**
     *
     * @param n 物品数量
     * @param w 背包最大重量
     * @param wt 每个物品的重量
     * @param val 每个物品的价值
     * @return 最大价值
     */
    public int knapsack(int n, int w, int[] wt, int[] val){
        int[][] dp = new int[n+1][w+1];
        Arrays.fill(dp[0], 0);
        for (int[] row : dp) {
            row[0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= w ; j++) {
                //这种情况下不能装入背包
                if(j - wt[i - 1] < 0)
                    dp[i][j] = dp[i - 1][j];
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wt[i - 1]] + val[i - 1]);
                }

            }
        }

        return dp[n][w];
    }

    public static void main(String[] args) {
        int[] wt = {2, 1, 3};
        int[] val = {4, 2, 3};
        Backpack01 backpack01 = new Backpack01();
        System.out.println(backpack01.knapsack(3, 4, wt, val));
    }
}
