package org.example.algorithms;

import java.util.Arrays;

public class DIStringMatch_942 {
    public static int[] diStringMatch(String s) {
        char[] chars = s.toCharArray();
        int[] res = new int[chars.length + 1];
        int low = 0, high = chars.length;

        for (int i = 0; i < chars.length; i++) {
            res[i] = (chars[i] == 'I') ? low++ : high--;
        }
        res[chars.length] = low;
        return res;
    }

    public static void main(String[] args) {
        String a = "IDID"; // [0,4,1,3,2]
        String b = "III"; // [0,1,2,3]
        String c = "DDI"; // [3,2,0,1]
        System.out.println(Arrays.toString(diStringMatch(b)));
    }
}
