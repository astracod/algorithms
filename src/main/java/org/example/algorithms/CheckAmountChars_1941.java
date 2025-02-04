package org.example.algorithms;

public class CheckAmountChars_1941 {
    public static boolean areOccurrencesEqual(String s) {
        int[] charsArr = new int[26];
        for (char c : s.toCharArray()) {
            charsArr[c-97]++;
        }
        int charAmount = charsArr[s.charAt(0)-97];
        for (int j : charsArr) {
            if (j != 0 && j != charAmount) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abacbc";
        String s1 = "aaabb";
        System.out.println(areOccurrencesEqual(s1));
    }
}
