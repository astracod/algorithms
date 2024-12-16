package org.example.algorithms;

import java.util.*;

public class IntersectionOfTwoArrays_2 {
        public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int i : nums1) {
            map1.merge(i,1,Integer::sum);
        }

        for (int i : nums2) {
            map2.merge(i,1,Integer::sum);
        }
        if (map1.size() > map2.size()){
            for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
                Integer entry1 = map1.get(entry.getKey());
                if (entry1 != null){
                    int key = entry.getKey();
                    int size = Math.min(entry.getValue(), entry1);
                    for (int i = 0; i < size; i++) {
                        res.add(key);
                    }
                }
            }
        }
        else {
            for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
                Integer entry2 = map2.get(entry.getKey());
                if (entry2 != null){
                    int key = entry.getKey();
                    int size = Math.min(entry.getValue(), entry2);
                    for (int i = 0; i < size; i++) {
                        res.add(key);
                    }
                }
            }
        }

        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }


    public static void main(String[] args) {
        int[] arr1 = new int[]{4, 9, 5};
        int[] arr2 = new int[]{9, 4, 9, 8, 4};
        int[] res = intersect(arr1, arr2);
        System.out.println(Arrays.toString(res));
    }
}
