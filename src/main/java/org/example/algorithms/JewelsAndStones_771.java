package org.example.algorithms;

import java.util.HashMap;
import java.util.Map;

public class JewelsAndStones_771 {
    public static int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> storage = new HashMap<>();
        int amount = 0;
        for (int i = 0; i < stones.length(); i++) {
            storage.merge(stones.charAt(i), 1, Integer::sum);
        }
        for (int i = 0; i < jewels.length(); i++) {
            Integer entry = storage.get(jewels.charAt(i));
            if (entry != null) amount += entry;
        }
        return amount;
    }

    public static void main(String[] args) {
        String jewels = "aA", stones = "aAAbbbb";
        String jewels1 = "z", stones1 = "ZZ";
        System.out.println(numJewelsInStones(jewels1, stones1));

    }
}
