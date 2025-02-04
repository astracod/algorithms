package org.example.algorithms;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate2_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> digits = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = digits.get(nums[i]);
            if (index != null) {
                if (i - index <= k) return true;
                else digits.put(nums[i], i);
            } else digits.put(nums[i], i);
        }
        return false;
    }
}
