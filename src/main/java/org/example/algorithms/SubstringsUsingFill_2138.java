package org.example.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubstringsUsingFill_2138 {
    public static String[] divideString(String s, int k, char fill) {
        List<String> resultList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i + k - 1 < s.length()) {
                resultList.add(s.substring(i, i + k));
                i = i + k - 1;
            } else {
                sb.append(s.substring(i));
                index = k - (s.length() % k);
                break;
            }
        }
        if (index > 0){
            while (index > 0) {
                sb.append(fill);
                index--;
            }
            resultList.add(sb.toString());
        }
        return resultList.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String s = "abcdefghi";
        int k = 3;
        char fill = 'x';
        String s1 = "abcdefghij";
        String s2 = "ctoyjrwtngqwt";
        int k2 = 8;
        char fill2 = 'n';
        // ["ctoyjrwt","ngqwtnnn"]
        System.out.println(Arrays.toString(divideString(s1, k, fill)));
    }
}
