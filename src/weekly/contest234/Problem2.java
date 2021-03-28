package weekly.contest234;

import java.util.List;

/**
 * @author WRK
 * @date 2021/3/28 11:33
 */
public class Problem2 {
    public int reinitializePermutation(int n) {
        int[] perm = new int[n];
        int[] arr = new int[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            perm[i] = i;
        }
        perm = swap(perm, arr);
        result += 1;
        while(!isValid(perm)) {
            perm = swap(perm, arr);
            result += 1;
        }
        return result;
    }

    private boolean isValid(int[] perm) {
        for (int i = 0; i < perm.length; i++) {
            if(perm[i] != i)
                return false;
        }
        return true;
    }

    private int[] swap(int[] perm, int[] arr){
        int n = perm.length;
        for (int i = 0; i < n; i++) {
            if(i % 2 == 0)
                arr[i] = perm[i / 2];
            else
                arr[i] = perm[n / 2 + (i - 1) / 2];
        }
        for (int i = 0; i < n; i++) {
            perm[i] = arr[i];
        }
        return perm;
    }
}
