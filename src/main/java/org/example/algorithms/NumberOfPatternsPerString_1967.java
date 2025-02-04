package org.example.algorithms;

public class NumberOfPatternsPerString_1967 {
    public static int numOfStrings(String[] patterns, String word) {
        int amount = 0;
        for (String pattern : patterns) {
            if (word.contains(pattern)) amount++;
        }
        return amount;
    }

    public static void main(String[] args) {
        String[] patterns = new String[]{"a", "abc", "bc", "d"};
        String word = "abc";
        String[] patterns1 = new String[]{"a", "b", "c"};
        String word1 = "aaaaabbbbb";
        String[] patterns2 = new String[]{"a", "a", "a"};
        String word2 = "ab";
        System.out.println(numOfStrings(patterns2, word2));
    }
}
