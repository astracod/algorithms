package org.example.algorithms;

import java.util.Arrays;

public class MaximumProductOfThreeNumbers_628 {

    /**
     *  решение поиска чисел при 1 проходе и заполнения переменных по принципу 3 максимальных и 2 минимальных
     *  работает быстрее всего. То есть надо было создать maxValue, midValue, minValue, maxNegative, midNegative.
     *  проходя по массиву заполнять и потом отдать в Math.max;
     */
    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int negativePostfix = nums[0] * nums[1] * nums[nums.length - 1];
        int positiveRow = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        return Math.max(negativePostfix, positiveRow);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-10, -7, -3, -1, 2, 5, 8, 12};
        int[] nums2 = new int[]{-10, -9, -3, -1};// -270
        int[] nums3 = new int[]{-10, -2, 5};// 100
        int[] nums4 = new int[]{-1, -2, -3, -4};// -6

        System.out.println(maximumProduct(nums2));
//        System.out.println(-10 * (-7) * 12);
//        System.out.println(5 * 8 * 12);
    }
}
