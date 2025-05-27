package org.example.algorithms;

import java.util.Arrays;

public class MinimumSumOfFourDigit_2160 {
    public static int minimumSum(int num) {
        int[] arr = new int[4];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = num % 10;
            num = num / 10;
        }
        Arrays.sort(arr);
        return (arr[0] * 10 + arr[2]) + (arr[1] * 10 + arr[3]);
    }

    public static void main(String[] args) {
        int num = 2932; // 52
        int num1 = 4009; // 13
        System.out.println(minimumSum(num));
    }
}
