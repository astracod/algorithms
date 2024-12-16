package org.example.algorithms;

public class ReverseString2 {


    /**
     * Решение чужое, осознать
     */
    private static void reverse(char[] charArray, int start, int end) {
        while (start < end) {
            char temp = charArray[start];
            charArray[start++] = charArray[end];
            charArray[end--] = temp;
        }
    }

    public static String reverseStr(String s, int k) {
        char[] charArray = s.toCharArray();
        int n = charArray.length;
        int pointcut = 2 * k;
        for (int i = 0; i < n; i += pointcut) {
            int end = Math.min(i + k - 1, n - 1);
            reverse(charArray, i, end);
        }

        return new String(charArray);
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        String s2 = "abcd";
        System.out.println(reverseStr(s, 2));

    }
}
