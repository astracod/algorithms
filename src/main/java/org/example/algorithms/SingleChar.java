package org.example.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingleChar {

    public static List<Character> findSingleChar(String str){
        char[] ch = str.toLowerCase().toCharArray();
        Map<Character, Integer> sortedMap = new HashMap<>();
        List<Character> res = new ArrayList<>();

        for (char c : ch) {
            if (sortedMap.containsKey(c)) {
                sortedMap.put(c, sortedMap.get(c) + 1);
            } else {
                sortedMap.put(c, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : sortedMap.entrySet()) {
            if (entry.getValue() == 1){
                res.add(entry.getKey());
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String kitOfChars = "AaBbccfggkjj";
        System.out.println(SingleChar.findSingleChar(kitOfChars));

    }
}
