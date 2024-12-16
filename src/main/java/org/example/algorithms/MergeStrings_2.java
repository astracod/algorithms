package org.example.algorithms;

public class MergeStrings_2 {

    public static String mergeAlternately(String word1, String word2) {
        String rest;
        int i = 0;
        int j = 0;
        StringBuilder result = new StringBuilder();

        while (i < word1.length() && j < word2.length()) {
            result.append(word1.charAt(i));
            result.append(word2.charAt(j));
            i++;
            j++;
        }

        if (i < word1.length()) rest = word1.substring(i);
        else rest = word2.substring(j);

        result.append(rest);

        return result.toString();
    }
}
