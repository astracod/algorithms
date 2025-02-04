package org.example.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MakeArrayZero_2357 {

    /**
     *  Количество операций для приведения массива к значениям равным нулю, равно количеству уникальных чисел.
     */
    public int minimumOperationsFromSolutions(int[] nums) {
        boolean[] visited = new boolean[1000];
        int minimum = 0;
        visited[0] = true;
        for (int num : nums) {
            if (!visited[num]) {
                visited[num] = true;
                minimum++;
            }
        }
        return minimum;
    }
    public static int minimumOperations(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (num > 0) list.add(num);
        }
        if (list.isEmpty()) return 0;
        int count = 0;
        while (!list.isEmpty()) {
            int min = Collections.min(list);
            for (int i = 0; i < list.size(); i++) {
                int res = list.get(i) - min;
                if (res > 0) {
                    list.set(i, res); // Обновляем значение на месте
                } else {
                    list.remove(i); // Удаляем элемент, если он стал 0
                    i--; // Сдвигаем индекс назад из-за удаления
                }
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        int[] nums = new int[]{1, 5, 0, 3, 5};// 3
        int[] nums1 = new int[]{0};
        System.out.println(minimumOperations(nums1));
    }
}
