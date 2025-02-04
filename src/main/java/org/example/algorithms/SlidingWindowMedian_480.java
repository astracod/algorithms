package org.example.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SlidingWindowMedian_480 {

    // maxSlidingWindow проанализировать. Это решение падает по Time Limit Exceeded 32 / 43 testcases passed
    public static double[] medianSlidingWindow(int[] nums, int k) {
        List<List<Integer>> listOfLists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int lastIndex = k - 1;
        for (int i = 0; i < k; i++) {
            list.add(nums[i]);
        }

        listOfLists.add(list);
        for (int i = 1; i + k - 1 < nums.length; i++) {
            List<Integer> newList = new ArrayList<>(listOfLists.get(listOfLists.size() - 1));
            newList.remove(0);
            newList.add(nums[lastIndex + i]);
            listOfLists.add(newList);
        }
        int oddIndex = k / 2;
        int evenIndex = (k / 2) - 1;

        List<Double> resList = new ArrayList<>();
        for (List<Integer> cur : listOfLists) {
            Collections.sort(cur);
            if (k % 2 != 0) {
                resList.add((double) cur.get(oddIndex));
            } else {
                double val = ((double) cur.get(evenIndex) + cur.get(oddIndex)) / 2;
                resList.add(val);
            }

        }

        return resList.stream().mapToDouble(Double::doubleValue).toArray();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] nums2 = new int[]{1, 2, 3, 4, 2, 3, 1, 4, 2};
        int[] nums3 = new int[]{1,4,2,3};
        System.out.println(Arrays.toString(medianSlidingWindow(nums2, 3)));
//        System.out.println("1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000");
        System.out.println("2.00000,3.00000,3.00000,3.00000,2.00000,3.00000,2.00000");
    }
}
