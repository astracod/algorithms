package org.example.algorithms;

import java.util.Arrays;

public class LongestHarmoniousSubsequence_594 {
    public static int findLHS(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int max = 0;
        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > 1) left++;
            if (nums[right] - nums[left] == 1) max = Math.max(max, right - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2, 2, 5, 2, 3, 7};
        int[] nums1 = new int[]{1, 2, 3, 4};
        System.out.println(findLHS(nums));
    }
}
