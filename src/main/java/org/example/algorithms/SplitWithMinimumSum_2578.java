package org.example.algorithms;

import java.util.Arrays;

public class SplitWithMinimumSum_2578 {
    public static int splitNum(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        Arrays.sort(digits);

        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();

        boolean addToFirst = true;
        for (char c : digits) {
            if (c == '0') continue;
            if (addToFirst) {
                num1.append(c);
            } else {
                num2.append(c);
            }
            addToFirst = !addToFirst;
        }

        int n1 = num1.length() == 0 ? 0 : Integer.parseInt(num1.toString());
        int n2 = num2.length() == 0 ? 0 : Integer.parseInt(num2.toString());
        return n1 + n2;
    }

    public static void main(String[] args) {
        int num = 4325; // 59
        int num1 = 687; // 75
        int num2 = 10001; // 2
        int num3 = 1000; // 1
        int num4 = 2100; // 3
        System.out.println(splitNum(num4));
    }
}
