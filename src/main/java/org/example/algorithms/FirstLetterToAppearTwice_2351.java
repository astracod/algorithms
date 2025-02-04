package org.example.algorithms;

import java.util.HashMap;
import java.util.Map;

public class FirstLetterToAppearTwice_2351 {
    public static char repeatedCharacter(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (charMap.containsKey(c)) return c;
            else charMap.merge(c, 1, Integer::sum);
        }
        return 0;
    }

    public static void main(String[] args) {
        String s = "abccbaacz";
        String s1 = "abcdd";
        System.out.println(repeatedCharacter(s1));
    }
}
