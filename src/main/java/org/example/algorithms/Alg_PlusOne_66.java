package org.example.algorithms;

import java.util.Arrays;

public class Alg_PlusOne_66 {
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        // Начинаем с последнего элемента и добавляем 1
        for (int i = n - 1; i >= 0; i--) {
            // Увеличиваем текущую цифру на 1
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0; // Если цифра была 9, устанавливаем её в 0
        }

        // Если мы вышли из цикла, это значит, что все цифры были 9
        int[] newArray = new int[n + 1];
        newArray[0] = 1; // Устанавливаем первую цифру в 1
        return newArray;
    }


    public static void main(String[] args) {
        int[] digits = new int[]{4, 3, 2, 1};
        int[] digits1 = new int[]{9, 9};
        System.out.println(Arrays.toString(plusOne(digits1)));
    }
}
