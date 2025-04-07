package org.example.algorithms;

import java.util.Arrays;

public class MinimumOperations_1827 {
    public static int minOperations(int[] nums) {
        if (nums.length == 1) return 0;
        int answer = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                int difference = (nums[i - 1] - nums[i]) + 1;
                nums[i] = difference + nums[i];
                answer += difference;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 2, 4, 1};
        int[] nums1 = new int[]{1, 1, 1};
        int[] nums2 = new int[]{8};
        System.out.println(minOperations(nums2));
    }
}
