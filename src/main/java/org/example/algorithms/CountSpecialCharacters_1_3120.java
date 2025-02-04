package org.example.algorithms;

public class CountSpecialCharacters_1_3120 {
    public static int numberOfSpecialChars(String word) {
        int[] sChars = new int[53];
        for (int i = 0; i < word.length(); i++) {
            char target = word.charAt(i);
            if (Character.isLowerCase(target)) sChars[target - 'a']++;
            else sChars[target - 'A' + 26]++;
        }
        int amount = 0;
        int index = 0;
        while (index < 27) {
            if (sChars[index] != 0 && sChars[index + 26] != 0) amount++;
            index++;
        }
        return amount;
    }

    public static void main(String[] args) {
        String word = "aaAbcBC";
        String word1 = "abc";
        String word2 = "abBCab";
        System.out.println(numberOfSpecialChars(word2));

    }
}
