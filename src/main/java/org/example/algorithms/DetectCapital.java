package org.example.algorithms;

public class DetectCapital {

    public static boolean detectCapitalUse(String word) {
        String pattern = "^(?:[A-Z]+|[a-z]+|[A-Z][a-z]+)$";
        return word.matches(pattern);
//        return word.matches("[A-Z]+") || word.matches("[a-z]+") || word.matches("^[A-Z][a-z]+$");
    }

    public static void main(String[] args) {
        String word = "USA";
        String word2 = "FlaG";
        String word3 = "hello";
        System.out.println(detectCapitalUse(word3));
    }
}
