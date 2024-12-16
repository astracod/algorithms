package org.example.algorithms;

import java.util.Arrays;

public class FindIndexes_2903 {

    public static int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int[] result = new int[2];
        result[0] = -100;
        result[1] = -100;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (Math.abs(i - j) >= indexDifference
                        && Math.abs(nums[i] - nums[j]) >= valueDifference) {
                    result[0] = i;
                    result[1] = j;
                }
            }
            if (result[0] != -100) break;
        }
        if (result[0] == -100) {
            result[0] = -1;
            result[1] = -1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 1, 4, 1};
        int[] nums2 = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(findIndices(nums, 2, 4)));
    }
}
