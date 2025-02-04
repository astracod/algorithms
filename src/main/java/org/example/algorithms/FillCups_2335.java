package org.example.algorithms;

import java.util.Collections;
import java.util.PriorityQueue;

public class FillCups_2335 {
    public static int fillCups(int[] amount) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : amount) {
            if (i > 0) pq.add(i);
        }
        int count = 0, first, second = 0;
        while (!pq.isEmpty()) {
            if (pq.size() > 1) {
                first = pq.poll() - 1;
                second = pq.poll() - 1;

                if (first > 0) {
                    pq.add(first);
                }
                if (second > 0) {
                    pq.add(second);
                }
            } else {
                first = pq.poll() - 1;
                if (first > 0) {
                    pq.add(first);
                }
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] amount = new int[]{1, 4, 2};// 4
        int[] amount1 = new int[]{5, 4, 4};// 7
        int[] amount2 = new int[]{5, 0, 0};// 5
        System.out.println(fillCups(amount2));
    }
}
