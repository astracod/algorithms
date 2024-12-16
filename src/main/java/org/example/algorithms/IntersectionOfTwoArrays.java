package org.example.algorithms;

import java.util.*;

public class IntersectionOfTwoArrays {

    public static int[] intersection(int[] nums1, int[] nums2) {
        int[] setArr;
        Set<Integer> set = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        if (nums1.length < nums2.length) setArr = nums1;
        else setArr = nums2;

        for (int i : setArr) {
            set.add(i);
        }

        if (setArr == nums1) {
            for (int i : nums2) {
                if (set.contains(i)) result.add(i);
            }
        } else {
            for (int i : nums1) {
                if (set.contains(i)) result.add(i);
            }
        }

        int[] array = new int[result.size()];
        int index = 0;
        for (Integer integer : result) {
            array[index] = integer;
            index++;
        }

        return array;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{4, 9, 5};
        int[] arr2 = new int[]{9, 4, 9, 8, 4};
        int[] res = intersection(arr1, arr2);
        System.out.println(Arrays.toString(res));
    }
}
