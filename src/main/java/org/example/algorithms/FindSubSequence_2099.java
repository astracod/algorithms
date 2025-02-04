package org.example.algorithms;

import java.util.*;

public class FindSubSequence_2099 {
    public static int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> workQ = new PriorityQueue<>(
                (a, b) -> {
                    if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
                    return Integer.compare(b[0], a[0]);
                }
        );

        for (int i = 0; i < nums.length; i++) {
            workQ.add(new int[]{nums[i], i});
        }

        List<int[]> selected = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            selected.add(workQ.poll());
        }

        // Сортируем выбранные элементы по индексу
        selected.sort(Comparator.comparingInt(a -> a[1]));

        // Формируем результирующий массив
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = selected.get(i)[0];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 3, 3}; // 2
        int[] nums1 = new int[]{-1, -2, 3, 4}; // 3
        int[] nums2 = new int[]{3, 4, 3, 3}; // 2
        int[] nums3 = new int[]{50, -75}; // 2
        System.out.println(Arrays.toString(maxSubsequence(nums3, 2)));
    }
}
