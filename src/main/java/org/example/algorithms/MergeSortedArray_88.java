package org.example.algorithms;

import java.util.Arrays;

public class MergeSortedArray_88 {
    /**
     * слияние 2 отсортированных массивов
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0 && n != 0) {
            System.arraycopy(nums2, 0, nums1, 0, nums2.length);
        }
        if (n == 0) return;
        int i = m - 1;
        int k = m + n - 1;
        int j = n - 1;
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        int m = 3, n = 3;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
