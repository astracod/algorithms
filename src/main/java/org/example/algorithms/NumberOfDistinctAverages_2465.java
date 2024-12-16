package org.example.algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctAverages_2465 {

    public static int distinctAverages(int[] nums) {
        Set<Double> set = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            double sumAverages = (double) (nums[i] + nums[j]) / 2;
            set.add(sumAverages);
        }
        return set.size();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,2,2,0,4,0};
        System.out.println(distinctAverages(nums));
    }
}
