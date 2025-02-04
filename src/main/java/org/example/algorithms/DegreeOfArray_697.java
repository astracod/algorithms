package org.example.algorithms;

import java.util.*;

public class DegreeOfArray_697 {
    public static int findShortestSubArray(int[] nums) {
        Map<Integer, List<Integer>> count = new HashMap<>();
        int degree = 1;
        int res = 50000;
        for (int i = 0; i < nums.length; i++) {
            List<Integer> val = count.get(nums[i]);
            if (val != null) {
                val.add(i);
                if (val.size() > degree) degree = val.size();
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                count.put(nums[i], list);
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : count.entrySet()) {
            if (entry.getValue().size() == degree) {
                List<Integer> list = entry.getValue();
                int a = list.get(list.size()-1) - list.get(0)+1;
                if (a < res) res = a;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 3, 1, 4, 2};
        int[] nums2 = new int[]{1, 2, 2, 3, 1};
        int[] nums3 = new int[]{2,1};
        System.out.println(findShortestSubArray(nums3));
    }
}
