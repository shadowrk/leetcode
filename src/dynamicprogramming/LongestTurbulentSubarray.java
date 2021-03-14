package dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author WRK
 * @date 2021-01-19 14:17
 */
public class LongestTurbulentSubarray {
    public int maxTurbulenceSize(int[] A) {
        int N = A.length;
        int ans = 1;
        int anchor = 0;

        for (int i = 1; i < N; ++i) {
            int c = Integer.compare(A[i-1], A[i]);
            if (i == N-1 || c * Integer.compare(A[i], A[i+1]) != -1) {
                if (c != 0) ans = Math.max(ans, i - anchor + 1);
                anchor = i;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{
//                9,4,2,10,7,8,8,1,9
//                100
                4, 8, 12, 16
        };
        LongestTurbulentSubarray test = new LongestTurbulentSubarray();
        test.maxTurbulenceSize(arr);
    }
}


