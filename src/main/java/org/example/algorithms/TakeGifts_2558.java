package org.example.algorithms;

import java.util.Collections;
import java.util.PriorityQueue;

public class TakeGifts_2558 {
    public static long pickGifts(int[] gifts, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int gift : gifts) {
            if (gift > 0) pq.add((long) gift);
        }

        while (k > 0 && !pq.isEmpty()) {
            long gift = pq.poll();
            long sqrtGift = (long) Math.sqrt(gift);
            pq.add(sqrtGift);
            k--;
        }

        long sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] gifts = new int[]{25, 64, 9, 4, 100};
        int[] gifts1 = new int[]{1, 1, 1, 1};
        System.out.println(pickGifts(gifts1, 4));
    }
}
