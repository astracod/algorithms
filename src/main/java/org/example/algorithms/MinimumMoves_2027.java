package org.example.algorithms;

public class MinimumMoves_2027 {
    public static int minimumMoves(String s) {
        int countMoves = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'X') {
                countMoves++;
                if (i + 2 < s.length()) {
                    i += 2;
                } else break;
            }
        }
        return countMoves;
    }

    public static void main(String[] args) {
        String s = "XXX";
        String s1 = "XXOX";
        String s2 = "OOOO";
        String s3 = "OXXOXXXXXXOXX";
        String s4 = "OXOXOXOX";
        String s5 = "OXOX";
        System.out.println(minimumMoves(s1));
    }
}
