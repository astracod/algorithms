package org.example.algorithms;

import java.util.*;

public class KthDistinctStringAnArr_2053 {
    public static String kthDistinct(String[] arr, int k) {

        Map<String, Integer> map = new LinkedHashMap<>();
        for (String s : arr) {
            map.merge(s, 1, Integer::sum);
        }
        int index = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1 && index == k - 1) return entry.getKey();
            if (entry.getValue() == 1 && index < k - 1) index++;
        }

        return "";
    }

    public static void main(String[] args) {
        String[] arr = new String[]{"d", "b", "c", "b", "c", "a"};
        int k = 2;
        String[] arr1 = new String[]{"aaa", "aa", "a"};
        int k1 = 1;
        String[] arr2 = new String[]{"a", "b", "a"};
        int k2 = 3;
        System.out.println(kthDistinct(arr, k));
    }
}
