package org.example.algorithms;

import java.util.Arrays;

public class MaximizeSumOfArrayAfterK_1005 {
    public static int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
            if (nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }
            if (k == 0 && nums[i] >= 0) break;
        }

        if (k % 2 != 0) nums[minIndex] = -nums[minIndex];

        int sum = 0; // работает сильно быстрее stream
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 2, 3};
        int[] nums1 = new int[]{3, -1, 0, 2};
        int[] nums2 = new int[]{2, -3, -1, 5, -4};
        System.out.println(largestSumAfterKNegations(nums, 1));
    }
}
