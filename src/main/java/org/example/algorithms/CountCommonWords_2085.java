package org.example.algorithms;

import java.util.HashMap;
import java.util.Map;

public class CountCommonWords_2085 {
    public static int countWords(String[] words1, String[] words2) {
        int commonWords = 0;
        Map<String, Integer> strings1 = new HashMap<>();
        Map<String, Integer> strings2 = new HashMap<>();
        for (String s : words1) {
            strings1.merge(s,1,Integer::sum);
        }
        for (String s : words2) {
           strings2.merge(s,1,Integer::sum);
        }
        for (Map.Entry<String, Integer> entry : strings1.entrySet()) {
            if (entry.getValue() == 1
                    && strings2.get(entry.getKey()) != null
                    && (strings2.get(entry.getKey()) == 1)) commonWords++;
        }
        return commonWords;
    }

    public static void main(String[] args) {
        String[] words1 = new String[]{"leetcode", "is", "amazing", "as", "is"};
        String[] words2 = new String[]{"amazing", "leetcode", "is"};
        String[] words3 = new String[]{"b", "bb", "bbb"};
        String[] words4 = new String[]{"a", "aa", "aaa"};
        String[] words5 = new String[]{"a", "ab"};
        String[] words6 = new String[]{"a", "a", "a", "ab"};
        System.out.println(countWords(words5,words6));
    }
}
