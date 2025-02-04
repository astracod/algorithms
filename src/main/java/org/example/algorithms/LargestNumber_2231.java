package org.example.algorithms;

import java.util.*;

public class LargestNumber_2231 {
    public static int largestInteger(int num) {
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> odd = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> even = new PriorityQueue<>(Comparator.reverseOrder());
        int digit = num;

        while (digit > 0) {
            int res = digit % 10;
            if (res % 2 == 0) {
                even.add(res);
            } else {
                odd.add(res);
            }
            list.add(res);
            digit = digit / 10;
        }

        // Массив для хранения результата
        int[] array = new int[list.size()];

        // Переносим элементы в массив в обратном порядке
        for (int j = 0; j < list.size(); j++) {
            array[j] = list.get(list.size() - 1 - j);
        }

        for (int k = 0; k < array.length; k++) {
            if (array[k] % 2 == 0 && !even.isEmpty()) {
                array[k] = even.poll();
            } else if (array[k] % 2 != 0 && !odd.isEmpty()) {
                array[k] = odd.poll();
            }
        }

        int result = 0;
        for (int j : array) {
            result = result * 10 + j;
        }

        return result;
    }


    public static void main(String[] args) {
        int num = 1234;
        int num1 = 65875;
        System.out.println(largestInteger(num1));
    }
}
