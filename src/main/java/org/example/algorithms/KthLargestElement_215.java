package org.example.algorithms;

import java.util.PriorityQueue;

public class KthLargestElement_215 {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int num : nums) {
            pq.add(num);
        }

        while (k - 1 > 0) {
            pq.poll();
            k--;
        }
        if (!pq.isEmpty()) return pq.poll();
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        int[] nums1 = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest(nums1, 4));
    }
}
