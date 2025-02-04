package org.example.algorithms;

import java.util.HashSet;
import java.util.Set;

public class SearchingSameSubstring_3083 {

    /**
     * чужое решение за лучшее время 1 ms
     */
    public boolean isSubstringPresentHint(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String rev = sb.toString();
        for (int i = 0; i < s.length() - 1; i++) {
            if (rev.contains(s.substring(i, i + 2))) {
                return true;
            }
        }
        return false;
    }

    /**
     *  мое решение за 4 ms Beats 40.53%
     */
    public static boolean isSubstringPresent(String s) {
        Set<String> stringSet = new HashSet<>();
        String revers = new StringBuilder(s).reverse().toString();
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length()) {
                stringSet.add(s.substring(i, (i + 2)));
            }
        }
        for (String s1 : stringSet) {
            if (revers.contains(s1)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        String s1 = "abcba";
        String s2 = "abcd";
        System.out.println(isSubstringPresent(s2));
    }
}
