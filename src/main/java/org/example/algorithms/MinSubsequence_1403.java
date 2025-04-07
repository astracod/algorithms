package org.example.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinSubsequence_1403 {
    public static List<Integer> minSubsequence(int[] nums) {
        if (nums.length == 1) return List.of(nums[0]);
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int currentSum = 0;
        List<Integer> answer = new ArrayList<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            currentSum += nums[i];
            sum -= nums[i];
            answer.add(nums[i]);
            if (currentSum > sum) break;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 10, 9, 8}; // [10,9]
        int[] nums1 = new int[]{4, 4, 7, 6, 7}; // [7,7,6]
        int[] nums2 = new int[]{10, 2, 5}; // [10]
        int[] nums3 = new int[]{8, 8}; // [8,8]
        System.out.println(minSubsequence(nums3));
    }
}
