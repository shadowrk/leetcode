package dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 887. 鸡蛋掉落
 * @author WRK
 * @date 2021/3/29 20:07
 */
public class SuperEggDrop {
    private int[][] memo;
//    private Map<Integer, Integer> memo = new HashMap<>();

    /**
     * 解法一，可以正确解出答案，但是效率低，会超时，待优化
     * @param K
     * @param N
     * @return
     */
    public int superEggDrop(int K, int N) {
        memo = new int[K+1][N+1];
        for (int i = 0; i < K + 1; i++) {
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }
        return dp2(K, N);
    }

//    private int dp(int K, int N){
//        if(K == 1)
//            return N;
//        if(N == 0)
//            return 0;
////        if(memo[K][N] != Integer.MAX_VALUE)
////            return memo[K][N];
//        if(memo.containsKey(N * 100 + K))
//            return memo.get(N * 100 + K);
//        int res = Integer.MAX_VALUE;
//        for (int i = 1; i < N + 1; i++) {
//            res = Math.min(res, Math.max(dp(K-1, i - 1), dp(K, N - i)) + 1);
//        }
////        memo[K][N] = res;
//        memo.put(N * 100 + K, res);
//        return res;
//
//    }
    private int dp2(int K, int N){
        if(K == 1)
            return N;
        if(N == 0)
            return 0;
        if(memo[K][N] != Integer.MAX_VALUE)
            return memo[K][N];
//        if(memo.containsKey(N * 100 + K))
//            return memo.get(N * 100 + K);
        int res = Integer.MAX_VALUE;
        int l = 1, r = N;
        while (l <= r){
            int mid = (l + r) / 2;
            int broken = dp2(K - 1, mid - 1);
            int noBroken = dp2(K, N - mid);
            if(broken > noBroken){
                r = mid - 1;
                res = Math.min(res, broken + 1);
            }else {
                l = mid + 1;
                res = Math.min(res, noBroken + 1);
            }
        }
        memo[K][N] = res;
//        memo.put(N * 100 + K, res);
        return res;

    }

    public static void main(String[] args) {
        SuperEggDrop p = new SuperEggDrop();
        System.out.println(p.superEggDrop(2, 6));
    }
}

