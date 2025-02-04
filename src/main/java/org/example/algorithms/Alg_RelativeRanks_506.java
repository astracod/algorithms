package org.example.algorithms;

import java.util.Arrays;

public class Alg_RelativeRanks_506 {
    public static String[] findRelativeRanks(int[] score) {
        String[] result = new String[score.length];
        Integer[] indices = new Integer[score.length];
        for (int i = 0; i < score.length; i++) {
            indices[i] = i;
        }
        // в массиве indices сортируем значения используя значения из скор и получаем [0, 3, 2, 4, 1]
        // потом используем их для сопоставления с входным массивом и заполняем результирующий
        Arrays.sort(indices, (a, b) -> Integer.compare(score[b], score[a]));
        System.out.println(Arrays.toString(indices));
        for (int i = 0; i < score.length; i++) {
            if (i == 0) {
                result[indices[i]] = "Gold Medal";
            } else if (i == 1) {
                result[indices[i]] = "Silver Medal";
            } else if (i == 2) {
                result[indices[i]] = "Bronze Medal";
            } else {
                result[indices[i]] = String.valueOf(i + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] score = new int[]{10, 3, 8, 9, 4};
        System.out.println(Arrays.toString(findRelativeRanks(score)));
    }
}
