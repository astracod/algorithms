package org.example.algorithms;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumUnits_1710 {

    public static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, Comparator.comparingInt((int[] arr) -> arr[1]).reversed());
        int units = 0;
        for (int[] boxType : boxTypes) {
            int current = Math.min(truckSize, boxType[0]);
            units += boxType[1] * current;
            truckSize -= current;
            if (truckSize <= 0) break;
        }
        return units;
    }

    public static void main(String[] args) {
        int[][] boxTypes = new int[][]{{1, 3}, {2, 2}, {3, 1}};
        int[][] boxTypes1 = new int[][]{{5, 10}, {2, 5}, {4, 7}, {3, 9}};
        System.out.println(maximumUnits(boxTypes, 4));
    }
}
