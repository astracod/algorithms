package org.example.algorithms;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight_1046 {
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            pq.add(stone);
        }
        if (stones.length == 1) return stones[0];
        while (!pq.isEmpty()) {
            int first = pq.poll();
            if (pq.isEmpty()) return first;
            else {
                int second = pq.poll();
                if (first != second) {
                    pq.add(first - second);
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] stones = new int[]{2, 7, 4, 1, 8, 1};
        int[] stones1 = new int[]{2,2};
        System.out.println(lastStoneWeight(stones1));
    }
}
