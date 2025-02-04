package org.example.algorithms;

import java.util.*;

public class MinimumIndexSum_599 {
    public static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            List<Integer> arr = new ArrayList<>();
            arr.add(i);
            map.put(list1[i], arr);
        }
        for (int i = 0; i < list2.length; i++) {
            map.computeIfAbsent(list2[i], k -> new ArrayList<>()).add(i);
        }
        List<String> words = new ArrayList<>();
        Map<Integer, List<String>> res = new HashMap<>();
        for (Map.Entry<String, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1) {
                int sum = entry.getValue().stream().mapToInt(Integer::intValue).sum();
                res.computeIfAbsent(sum, v -> new ArrayList<>()).add(entry.getKey());
            }
        }
        Map<Integer, List<String>> sortedMap = new TreeMap<>(res);
        for (Map.Entry<Integer, List<String>> integerListEntry : sortedMap.entrySet()) {
            words = integerListEntry.getValue();
            break;
        }

        return words.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] l1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] l2 = new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        String[] l3 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] l4 = new String[]{"KFC", "Shogun", "Burger King"};
        String[] l5 = new String[]{"happy", "sad", "good"};
        String[] l6 = new String[]{"sad", "happy", "good"};
        String[] l7 = new String[]{"eecba","dcddd","cceac","adbde","bbbdd","baaed","abdcc","cedbe","aedcd","ddeec",
                "aceda","cddcc","dbbdb","babca","abcbc","bcddd","acbbb","edcee","abcdc","dbeeb","bebdb","eeedc",
                "bdede","aeeea","cecec","bdcbb","caeda","cbdcd","ddcbe","bbdbd","acccb","eecdd","abbee","ebbde",
                "beead","ebaae","dadbc","cabdc","cbcda","aeedb","ceead","dbbee","ebdac","beadb","ceabe","ddbad",
                "adcbc","eaadb","dcbdd","badcd","edebd","KFC"};
        String[] l8 = new String[]{"dcddd","cceac","aaecb","bcbea","deecd","adbde","bbbdd","aedcd","aedda","eacbd",
                "dbbdb","babca","abcbc","bcddd","cbedb","edcee","abcdc","beacc","cdceb","bebdb","deadb","cecec",
                "bdcbb","bbedc","bbdbd","acccb","edbee","eecdd","accad","cceea","ebaae","cbbbd","cabdc","cbcda",
                "ceedb","ceead","beadb","baccd","aaaab","caeca","eddab","edebd","bccec","KFC"};
        System.out.println(Arrays.toString(findRestaurant(l7, l8)));
    }
}
