package org.example.algorithms;

import java.util.Arrays;

public class MinimumCost_2144 {
    public static int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int sum = 0, counter = 0;
        for (int i = cost.length-1; i >= 0; i--) {
            if (counter < 2) {
                sum += cost[i];
                counter++;
            }
            else counter = 0;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] cost = new int[]{6, 5, 7, 9, 2, 2};//23
        int[] cost1 = new int[]{1, 2, 3};//5
        int[] cost2 = new int[]{5, 5};//10
        int[] cost3 = new int[]{10, 5, 9, 4, 1, 9, 10, 2, 10, 8};// 48
        int[] cost4 = new int[]{2, 10, 5, 4, 3, 10, 5, 10};// 35
        System.out.println(minimumCost(cost));
    }

}
