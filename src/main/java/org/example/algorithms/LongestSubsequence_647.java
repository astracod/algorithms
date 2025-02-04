package org.example.algorithms;

public class LongestSubsequence_647 {
    public static int findLengthOfLCIS(int[] nums) {
        int maxCount = 1;
        int currentCount = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currentCount++;
            } else {
                maxCount = Math.max(maxCount, currentCount);
                currentCount = 1;
            }
        }

        return Math.max(maxCount, currentCount);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 4, 7};
        int[] nums1 = new int[]{2, 2, 2, 2, 2};
        int[] nums2 = new int[]{1, 3, 5, 4, 2, 3, 4, 5};
        System.out.println(findLengthOfLCIS(nums2));
    }
}
