package org.example.algorithms;

import java.util.Arrays;

public class LongestSubSequence_2389 {

    public static int findMaxK(int[] prefixSum, int query) {
        int left = 0, right = prefixSum.length - 1;
        int best = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (prefixSum[mid] <= query) {
                best = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return best;
    }

    public static int[] answerQueries(int[] nums, int[] queries) {
        Arrays.sort(nums);

        int[] prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = nums[i] + prefixSum[i];
        }

        int[] answer = new int[queries.length];
        int k = 0;
        for (int query : queries) {
            answer[k++] = findMaxK(prefixSum, query);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 2, 1};
        int[] queries = new int[]{3, 10, 21}; // [2, 3, 4]
        int[] nums1 = new int[]{2, 3, 4, 5};
        int[] queries1 = new int[]{1}; // [0]
        System.out.println(Arrays.toString(answerQueries(nums1, queries1)));
    }
}
