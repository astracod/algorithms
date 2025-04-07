package org.example.algorithms;

import java.util.Arrays;

public class NumberOfLinesToWriteStrings_806 {
    public static int[] numberOfLines(int[] widths, String s) {
        int sum = 0, lines = 1;
        for (int c : s.toCharArray()) {
            int width = widths[c - 'a'];
            if (sum + width > 100) {
                sum = 0;
                lines++;
            }
            sum += width;
        }
        return new int[]{lines, sum};
    }

    public static void main(String[] args) {
        int[] widths = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        String s = "abcdefghijklmnopqrstuvwxyz";
        int[] widths1 = {4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
        String s1 = "bbbcccdddaaa";
        System.out.println(Arrays.toString(numberOfLines(widths, s)));
    }
}
