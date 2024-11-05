package org.example.algorithms;

import java.util.*;

/*
Анагра́мма (от греч. ανα- «пере» + γράμμα «буква») — литературный приём,
состоящий в перестановке букв или звуков определённого слова (или словосочетания),
что в результате даёт другое слово или словосочетание.

Например:
Лунь - нуль
Воз - зов
Чертог - горечь
*/


class UniqueAnagrams {

    public static void main(String[] args) {
        List<String> anagrams = List.of("Race", "NIghT", "Angle", "CaRe", "angel", "ThiNG", "agnel", "angel");
        //"Race", "NIghT", "Angle" или "CaRe", "angel", "ThiNG"
        System.out.println(removeAnagrams(anagrams));
    }

    static Set<String> sortedString = new HashSet<>();
    static List<String> uniqueAnagrams = new ArrayList<>();
    private static String sortString(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
    //need to implement
    public static List<String> removeAnagrams(List<String> anagrams) {
        for (String anagram : anagrams) {
            String key = sortString(anagram.toLowerCase());
            if (!sortedString.contains(key)) {
                sortedString.add(key);
                uniqueAnagrams.add(anagram);
            }
        }
        return uniqueAnagrams;
    }
}