package org.example.algorithms;

public class MaxConsecutiveOnes_485 {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int currentCount = 0, maxCount = 0;
        for (int num : nums) {
            if (num == 1) {
                currentCount++;
            } else {
                if (currentCount != 0) maxCount = Math.max(currentCount, maxCount);
                currentCount = 0;
            }
        }
        maxCount = Math.max(currentCount, maxCount);
        return maxCount;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 0, 1, 1, 1};
        int[] nums1 = new int[]{1, 0, 1, 1, 0, 1};
        System.out.println(findMaxConsecutiveOnes(nums1));
    }
}
