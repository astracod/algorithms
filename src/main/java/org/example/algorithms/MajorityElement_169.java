package org.example.algorithms;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement_169 {
    public static int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];
        Map<Integer, Integer> map = new HashMap<>();
        int elem = 0, max = 0;
        for (int num : nums) {
            Integer amount = map.get(num);
            if (amount != null) {
                map.merge(num, 1, Integer::sum);
                if (amount + 1 > max) {
                    elem = num;
                    max = amount+1;
                }
            }
            else map.put(num,1);
        }
        return elem;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        int[] nums1 = new int[]{3, 2, 3};
        System.out.println(majorityElement(nums1));
    }
}
