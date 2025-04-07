package org.example.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class LargestPerimeterTriangle_976 {

    private static boolean validityOfTheCondition(int a, int b, int c) {
        return a + b > c && a + c > b && b + c > a;
    }

    public static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            int a = nums[i];
            int b = nums[i - 1];
            int c = nums[i - 2];
            if (validityOfTheCondition(a,b,c)) {
                return a + b + c;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 2};
        int[] nums1 = new int[]{1, 2, 1, 10};
        System.out.println(largestPerimeter(nums));
    }
}
