package org.example.algorithms;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies_575 {
    /**
     * n - количество конфет
     * candyType[i] - тип конфеты
     * сколько типов конфет можно съесть
     */
    public static int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int i : candyType) {
            set.add(i);
        }
        return Math.min(set.size(), candyType.length / 2);
    }

    public static void main(String[] args) {
        int[] candyType = new int[]{1,1,2,2,3,3};
        int[] candyType1 = new int[]{1,1,2,3};
        int[] candyType2 = new int[]{6,6,6,6};
        System.out.println(distributeCandies(candyType));
    }
}
