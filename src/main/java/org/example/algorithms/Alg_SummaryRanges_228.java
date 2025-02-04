package org.example.algorithms;

import java.util.ArrayList;
import java.util.List;

public class Alg_SummaryRanges_228 {
    /**
     * создание диапазонов
     */
    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            StringBuilder rs = new StringBuilder();
            rs.append(nums[i]);
            boolean flag = false;
            int last = -1;
            while (i + 1 < n && nums[i + 1] == nums[i] + 1) {
                ++i;
                flag = true;
                last = nums[i];
            }
            if (flag) {
                rs.append("->");
                rs.append(last);
            }
            list.add(rs.toString());
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 4, 5, 7};// ["0->2","4->5","7"]
        int[] nums1 = new int[]{0, 2, 3, 4, 6, 8, 9};// ["0","2->4","6","8->9"]
        int[] nums2 = new int[]{0, 1};
        System.out.println(summaryRanges(nums1));
    }
}
