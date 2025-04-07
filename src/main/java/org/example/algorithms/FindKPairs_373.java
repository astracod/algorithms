package org.example.algorithms;

import java.util.*;

public class FindKPairs_373 {
//    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
//        List<List<Integer>> res = new ArrayList<>();
//        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[0] + a[1]));
//
//        for (int i = 0; i < nums2.length && i < k; i++) {
//            pq.add(new int[]{nums1[0], nums2[i], 0});
//        }
//
//        while (k-- > 0 && !pq.isEmpty()) {
//            int[] cur = pq.poll();
//            res.add(List.of(cur[0], cur[1]));
//            int i = cur[2];
//            if (i + 1 < nums1.length){
//                pq.add(new int[]{nums1[i+1],cur[1], i+1});
//            }
//        }
//        return res;
//    }

    public record Triplet(int sum, int num1, int num2) {
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        PriorityQueue<Triplet> pq = new PriorityQueue<>(Comparator.comparingInt(t -> t.sum));

        pq.offer(new Triplet(nums1[0] + nums2[0], 0, 0));

        while (res.size() < k) {
            Triplet t = pq.poll();
            int i = t.num1, j = t.num2;

            res.add(List.of(nums1[i], nums2[j]));

            if (j + 1 < nums2.length) {
                pq.offer(new Triplet(nums1[i] + nums2[j + 1], i, j + 1));
            }

            if (j == 0 && i + 1 < nums1.length) {
                pq.offer(new Triplet(nums1[i + 1] + nums2[0], i + 1, 0));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 7, 11};// [[1,2],[1,4],[1,6]]
        int[] nums2 = new int[]{2, 4, 6};
        int[] nums3 = new int[]{1, 1, 2};// [[1,1],[1,1]]
        int[] nums4 = new int[]{1, 2, 3};
        int[] nums5 = new int[]{1, 2, 4, 5, 6};// [[1,3],[2,3],[1,5]]
        int[] nums6 = new int[]{3, 5, 7, 9};
        System.out.println(kSmallestPairs(nums5, nums6, 3));
    }
}
