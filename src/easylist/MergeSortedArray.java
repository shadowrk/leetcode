package easylist;

import java.util.Arrays;

public class MergeSortedArray {
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        for (int i = m; i < m + n; i++) {
//            nums1[i] = nums2[i - m];
//        }
//        Arrays.sort(nums1);
//    }

    /**
     * 结果显示，这两种方法时空复杂度上并没有太大的差别
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m - 1, q = n - 1, here = m + n - 1;
        while(p >= 0 && q >= 0){
            if(nums1[p] > nums2[q]){
                nums1[here --] = nums1[p --];
            }else{
                nums1[here --] = nums2[q --];
            }
        }
        while (q >= 0){
            nums1[here --] = nums2[q --];
        }
    }
}
