package org.example.algorithms;

import java.util.Arrays;

public class KMPAlgorithm {

    // Метод для вычисления префикс-функции
    private static int[] computePrefixFunction(String pattern) {
        int m = pattern.length();
        int[] pi = new int[m];
        int k = 0;

        for (int i = 1; i < m; i++) {
            while (k > 0 && pattern.charAt(k) != pattern.charAt(i)) {
                k = pi[k - 1];
            }
            if (pattern.charAt(k) == pattern.charAt(i)) {
                k++;
            }
            pi[i] = k;
        }
        System.out.println(Arrays.toString(pi));
        return pi;
    }

    // Метод для поиска подстроки
    public static void KMP(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int[] pi = computePrefixFunction(pattern);
        int q = 0; // количество символов, совпадающих с подстрокой

        for (int i = 0; i < n; i++) {
            while (q > 0 && pattern.charAt(q) != text.charAt(i)) {
                q = pi[q - 1]; // сдвигаем q по префикс-функции
            }
            if (pattern.charAt(q) == text.charAt(i)) {
                q++;
            }
            if (q == m) { // нашли совпадение
                System.out.println("Pattern found at index " + (i - m + 1));
                q = pi[q - 1]; // продолжаем искать
            }
        }
    }

    // Пример использования
    public static void main(String[] args) {
        String text = "ABCXABCDABXABCDABCDABCY";
        String pattern = "ABCDAB";
        KMP(text, pattern);
    }
}
