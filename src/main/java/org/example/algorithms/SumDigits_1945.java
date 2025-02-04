package org.example.algorithms;

public class SumDigits_1945 {
    public static int getLucky(String s, int k) {
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c - 96);
        }
        int i = 0;
        while (i < k) {
            for (int i1 = 0; i1 < sb.length(); i1++) {
                sum += sb.charAt(i1) - '0';
            }
            sb.setLength(0);
            sb.append(sum);
            i++;
            if (i < k) sum = 0;
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = "iiii";
        int k = 1;
        String s1 = "leetcode";
        int k1 = 2;
        String s2 = "zbax";
        int k2 = 2;
        System.out.println(getLucky(s2, k2));
    }
}
