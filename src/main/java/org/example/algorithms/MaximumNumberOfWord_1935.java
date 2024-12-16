package org.example.algorithms;

public class MaximumNumberOfWord_1935 {
//    public static int canBeTypedWords(String text, String brokenLetters) {
//        int amount = 0;
//        boolean res = true;
//        String[] arr = text.split(" ");
//        for (String s : arr) {
//            for (int i = 0; i < brokenLetters.length(); i++) {
//                if (s.contains(Character.toString(brokenLetters.charAt(i)))) res = false;
//            }
//            if (res) amount++;
//            res = true;
//        }
//        return amount;
//    }

    /**
     * решение из Accepted за 1 ms
     * мое решение за 8 ms
     */
    public static int canBeTypedWords(String text, String brokenLetters) {
        String[] arr = text.split(" ");
        char[] brokenChars = brokenLetters.toCharArray();
        boolean[] charExists = new boolean[26];
        for (char c : brokenChars) {
            charExists[c - 'a'] = true;
        }

        int count = 0;
        for (String word : arr) {
            if (!hasBrokenLetter(word, charExists)) {
                count++;
            }
        }
        return count;
    }

    public static boolean hasBrokenLetter(String s, boolean[] charExists) {
        for (int i = 0; i < s.length(); i++) {
            if (charExists[s.charAt(i) - 'a']) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String text = "hello world";
        String brokenLetters = "ad";
        System.out.println(canBeTypedWords(text, brokenLetters));
    }
}
