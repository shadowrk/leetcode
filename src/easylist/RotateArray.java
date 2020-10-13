package easylist;

import java.util.Arrays;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        k = k > nums.length ? k % nums.length : k;
        int n = nums.length - k;
        for (int i = 0; i < n / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[n - i - 1];
            nums[n - i -1] = temp;
        }
        for (int i = 0; i < (k / 2); i++){
            int temp = nums[n + i];
            nums[n + i] = nums[n + k - i - 1];
            nums[n + k - i -1] = temp;
        }

        for (int i = 0; i < (nums.length / 2); i++){
            int temp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }

    }

    public static void main(String[] args) {
        RotateArray r = new RotateArray();
        int[] arr = new int[]{1,2,3,4,5,6,7};
        r.rotate(arr, 3);
    }


}
