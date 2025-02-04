package org.example.algorithms;

import java.util.*;

public class FindXSum_3318 {

    public static int[] findXSum(int[] nums, int k, int x) {

        List<Integer> res = new ArrayList<>();
        int sum = 0;
        Comparator<Map.Entry<Integer, Integer>> comparator = (entry1, entry2) -> {
            // Сравнение по количеству
            int valueComparison = Integer.compare(entry2.getValue(), entry1.getValue());
            // Если количества равны, сравниваем по значению
            if (valueComparison == 0) {
                return Integer.compare(entry2.getKey(), entry1.getKey());
            }
            return valueComparison;
        };

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(comparator);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.merge(nums[i], 1, Integer::sum);
        }
        pq.addAll(map.entrySet());

        int i = x;
        while (i > 0 && !pq.isEmpty()) {
            Map.Entry<Integer, Integer> cur = pq.poll();
            sum += cur.getKey() * cur.getValue();
            i--;
        }
        res.add(sum);
        sum = 0;
        int j = k;
        int first = 0;
        while (j < nums.length) {
            Integer count = map.get(nums[first]);
            if (count > 1) {
                map.put(nums[first], count - 1);
            } else {
                map.remove(nums[first]);
            }
            map.merge(nums[j], 1, Integer::sum);
            pq = new PriorityQueue<>(comparator);
            pq.addAll(map.entrySet());
            int i1 = x;
            while (i1 > 0 && !pq.isEmpty()) {
                Map.Entry<Integer, Integer> cur = pq.poll();
                sum += cur.getKey() * cur.getValue();
                i1--;
            }
            res.add(sum);
            sum = 0;
            first++;
            j++;
        }

        int[] answer = new int[res.size()];
        for (int i1 = 0; i1 < answer.length; i1++) {
            answer[i1] = res.get(i1);
        }
        return answer;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 2, 3, 4, 2, 3};// 6,10,12
        int[] nums1 = new int[]{3, 8, 7, 8, 7, 5};// [11,15,15,15,12]
        System.out.println(Arrays.toString(findXSum(nums1, 2, 2)));
    }
}
