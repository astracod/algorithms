package org.example.algorithms;

import java.util.ArrayList;
import java.util.List;

public class LongestUnequalAdjacentGroupsSubsequence_2900 {
    public static List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        result.add(words[0]);
        for (int i = 1; i < groups.length; i++) {
            if (groups[i] != groups[i - 1]) result.add(words[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"e", "a", "b"}; // ["e","b"]
        int[] groups = new int[]{0, 0, 1};
        String[] words1 = new String[]{"a", "b", "c", "d"}; // ["a","b","c"]
        int[] groups1 = new int[]{1, 0, 1, 1};
        System.out.println(getLongestSubsequence(words, groups));
    }
}
