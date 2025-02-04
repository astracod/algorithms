package org.example.algorithms;

public class PercentageLetterInString_2278 {
    public static int percentageLetter(String s, char letter) {
        double count = 0;
        for (char c : s.toCharArray()) {
            if (c == letter) count++;
        }
        return (int) Math.floor(count / s.length() * 100);
    }

    public static void main(String[] args) {
        String s = "sgawtb";
        char letter = 's';
        System.out.println(percentageLetter(s, letter));
    }
}
