package org.example.algorithms;

public class LargestNumber_747 {
    public static int dominantIndex(int[] nums) {
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 && max / nums[i] < 2 && maxIndex != i) return -1;
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 6, 1, 0};
        int[] nums2 = new int[]{1, 2, 3, 4};
        System.out.println(dominantIndex(nums2));
    }
}
