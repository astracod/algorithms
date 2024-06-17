package org.example.algorithms;

import java.util.Arrays;

public class Fibonacci {
    /* Быстрое решение алгоритма Фибоначи */
    public static long fib(int n) {
        long[] res = new long[n + 1];
        if (n <= 1) {
            res[n] = n;
        } else {
            res[0] = 0;
            res[1] = 1;
            for (int i = 2; i <= n; i++) {
                res[i] = res[i - 1] + res[i - 2];
            }
        }
        return res[n];
    }

    /* Рекурсивное решение алгоритма Фибоначи */
    public static long fibSlow(int n) {
        long[] mem = new long[n + 1];
        Arrays.fill(mem, -1);
        return fibRecursion(n, mem);
    }

    private static long fibRecursion(int n, long[] mem) {
        if (mem[n] != -1) return mem[n];
        if (n <= 1) return n;
        long result = fibRecursion(n - 1, mem) + fibRecursion(n - 2, mem);
        mem[n] = result;
        return result;
    }


    public static void main(String[] args) {
        System.out.println(fib(100));
        System.out.println(fibSlow(10));
    }
}
