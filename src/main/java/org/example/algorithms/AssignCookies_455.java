package org.example.algorithms;

import java.util.Arrays;

public class AssignCookies_455 {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int result = 0, i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                result++;
                i++;
            }
            j++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] g = new int[]{1, 2, 3};
        int[] s = new int[]{1, 1};
        int[] g1 = new int[]{1, 2};
        int[] s1 = new int[]{1, 2, 3};
        System.out.println(findContentChildren(g1, s1));
    }
}
