package org.example.algorithms;

import java.util.Arrays;

public class SetMismatch_645 {
    public static int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        int[] statement = new int[nums.length+1];
        for (int num : nums) {
            statement[num]++;
        }
        for (int i = 1; i < statement.length; i++) {
            if (statement[i] == 0) res[1] = i;
            if (statement[i] == 2) res[0] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 4};// 2,3
        int[] nums2 = new int[]{1, 1};// 2,1
        int[] nums3 = new int[]{2, 2};// 1,2
        int[] nums4 = new int[]{3, 2, 2};// 1,2
        int[] nums5 = new int[]{3, 2, 3, 4, 6, 5};// 3,1
        System.out.println(Arrays.toString(findErrorNums(nums4)));
    }
}
