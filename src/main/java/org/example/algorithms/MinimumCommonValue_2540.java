package org.example.algorithms;

import java.util.HashSet;
import java.util.Set;

public class MinimumCommonValue_2540 {

    public static int getCommonLong(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    public static int getCommon(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) return nums1[i];

            else if (nums2[j] < nums1[i]) j++;

            else i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3};
        int[] nums2 = new int[]{0, 4};
        System.out.println(getCommon(nums1, nums2));
    }

}
