package org.example.algorithms;

public class MaximumAverageSubarray_643 {

    public static double findMaxAverage(int[] nums, int k) {
        double sum = 0.0, res;
        int end = k;
        for (int i = 0; i < end; i++) {
            sum += nums[i];
        }
        double beginAverageValue = sum / k;
        for (int i = 1; end < nums.length; i++, end++) {
            sum = sum - nums[i - 1] + nums[end];
            res = sum / k;
            if (res > beginAverageValue) beginAverageValue = res;
        }
        return beginAverageValue;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 12, -5, -6, 50, 3};
        int[] nums2 = new int[]{5};
        int[] nums3 = new int[]{3, 3, 4, 3, 0};
        int[] nums4 = new int[]{4, 2, 1, 3, 3};// 3.00000
        System.out.println(findMaxAverage(nums4, 2));
    }
}
