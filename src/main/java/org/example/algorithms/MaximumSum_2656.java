package org.example.algorithms;

public class MaximumSum_2656 {
    /**
     * Формула суммы арифметической прогрессии: S = k * m + k*(k-1)/2
     * Где m — начальный максимум, k — число операций.
     * Заменяет цикл сложения чисел m, m+1, ..., m+k-1.
     * Сложность: O(n) вместо O(n + k), оптимизация через математику.
     */
    public static int maximizeSum(int[] nums, int k) {
        int max = 0;
        for (int num : nums) {
            if (num > max) max = num;
        }

        return k * max + (k * (k - 1)) / 2;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5}; // 18
        int k = 3;
        int[] nums1 = new int[]{5, 5, 5}; // 11
        int k1 = 2;
        System.out.println(maximizeSum(nums, k));
    }
}
