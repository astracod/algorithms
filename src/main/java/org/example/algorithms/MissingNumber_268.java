package org.example.algorithms;

public class MissingNumber_268 {
    public static int missingNumber(int[] nums) {
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        // формула Гаусса для нахождения суммы всех натуральных чисел в последовательности от 0 до N
        int expectedSum = (nums.length * (nums.length + 1)) / 2;
        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 0, 1};
        int[] nums1 = new int[]{0, 1};
        int[] nums2 = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(missingNumber(nums2));
    }
}
