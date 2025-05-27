package org.example.algorithms;

public class Alg_MaximumDifference_2566 {
    public static int minMaxDifference(int num) {
        String s = String.valueOf(num);
        char first = s.charAt(0);
        char firstNonNineDigit = '9';
        int max = 0, min = 0;

        for (char c : s.toCharArray()) {
            if (c != '9') {
                firstNonNineDigit = c;
                break;
            }
        }

        for (char c : s.toCharArray()) {
            if (c == firstNonNineDigit) max = 10 * max + 9;
            else max = max * 10 + (c - '0');
        }

        for (char c : s.toCharArray()) {
            if (c == first) min = min * 10;
            else min = min * 10 + (c - '0');
        }

        return max - min;
    }

    public static void main(String[] args) {
        int num = 11891;
        int num1 = 90;
        int num2 = 911;
        System.out.println(minMaxDifference(num2));
    }
}
