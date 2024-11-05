package org.example.algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BinarySearchByBook {

    public static int binarySearch(int key, int[] a) {
        int min = 0, max = a.length - 1;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (key < a[mid]) max = mid - 1;
            else if (key > a[mid]) min = mid + 1;
            else return mid;
        }
        return -1;
    }

    /**
     * Общая временная сложность: O(n log n)
     *
     * @param a
     * @return
     */
    public static int countPair(int[] a) {
        Arrays.sort(a);
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (binarySearch(-a[i], a) > i) count++;
        }
        return count;
    }

    /**
     * Общая временная сложность O(N^2 log N)
     *
     * @param a
     * @return
     */
    public static int threeSum(int[] a) {
        Arrays.sort(a);
        int count = 0;
        Set<Integer> idx = new HashSet<>();

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int key = -(a[i] + a[j]);
                int index = binarySearch(key, a);
                if (index > j && a[i] + a[j] + a[index] == 0 && !idx.contains(index)) {
                    count++;
                    idx.add(index);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = new int[]{
                1, -1, 0,    // Первая тройка (1 + (-1) + 0 = 0)
                2, -2, 0,    // Вторая тройка (2 + (-2) + 0 = 0)
                3, 4, 5,     // Остальные уникальные числа
                6, 7, 8,
                9, 10, 11,
                12, 13, 14,
                15, 16, 17};
        System.out.println(threeSum(a));
    }
}
