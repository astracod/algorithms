package org.example.algorithms;

public class MinCostToMoveChips_1217 {
    public static int minCostToMoveChips(int[] position) {
        int odd = 0, even = 0;
        for (int i : position) {
            if (i % 2 == 0) even++;
            else odd++;
        }
        return Math.min(odd, even);
    }

    public static void main(String[] args) {
        int[] position = new int[]{1, 2, 3};
        int[] position1 = new int[]{2, 2, 2, 3, 3};
        int[] position2 = new int[]{1, 1000000000};
        System.out.println(minCostToMoveChips(position2));
    }
}
