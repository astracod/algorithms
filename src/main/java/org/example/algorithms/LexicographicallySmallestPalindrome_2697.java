package org.example.algorithms;

import java.util.Arrays;

public class LexicographicallySmallestPalindrome_2697 {
    public static String makeSmallestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            char leftChar = arr[left];
            char rightChar = arr[right];
            if (leftChar != rightChar){
                char minChar = (char) Math.min(leftChar, rightChar);
                arr[left] = minChar;
                arr[right] = minChar;
            }
            left++;
            right--;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        String s = "egcfe"; // efcfe
        String s1 = "abcd"; // abba
        String s2 = "seven"; // neven
        System.out.println(makeSmallestPalindrome(s2));
    }
}
