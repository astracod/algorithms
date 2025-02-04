package org.example.algorithms;

public class CheckStringsAlmostEquivalent_2068 {
    public static boolean checkAlmostEquivalent(String word1, String word2) {
        int[] w1 = new int[26];
        int[] w2 = new int[26];
        int index = 0, lastIndex = 0;
        while (index < word1.length()) {
            w1[word1.charAt(index) - 'a']++;
            w2[word2.charAt(index) - 'a']++;
            index++;
        }
        while (lastIndex < 26) {
            int res = Math.abs(w1[lastIndex] - w2[lastIndex]);
            if (res > 3) return false;
            lastIndex++;
        }
        return true;
    }

    public static void main(String[] args) {
        String word1 = "aaaa", word2 = "bccb";
        String word3 = "abcdeef", word4 = "abaaacc";
        String word5 = "cccddabba", word6 = "babababab";
        System.out.println(checkAlmostEquivalent(word5, word6));
    }
}
