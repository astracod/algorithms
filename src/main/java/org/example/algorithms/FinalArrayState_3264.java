package org.example.algorithms;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FinalArrayState_3264 {

    private record Pair(int value, int index) {
        public int getValue() {
            return value;
        }
    }

    public static int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (pair1, pair2) -> {
                    // Сравнение по значению
                    int valueComparison = Integer.compare(pair1.getValue(), pair2.getValue());
                    // Если значения равны, сравниваем по индексу
                    if (valueComparison == 0) {
                        return Integer.compare(pair1.index(), pair2.index());
                    }
                    return valueComparison;
                }
        );
        for (int i = 0; i < nums.length; i++) {
            Pair pair = new Pair(nums[i], i);
            pq.add(pair);
        }
        while (k > 0) {
            Pair pair = pq.poll();
            Pair newPair = new Pair(pair.value * multiplier, pair.index);
            nums[pair.index] = newPair.value;
            pq.add(newPair);
            k--;
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 3, 5, 6};// [8,4,6,5,6]
        int[] nums1 = new int[]{1, 2};//
        System.out.println(Arrays.toString(getFinalState(nums1, 3, 4)));
    }
}
