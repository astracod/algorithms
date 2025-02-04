package org.example.algorithms;

import java.util.*;

public class MostCommonWord_819 {

    public static String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap<>();
        String sanitizedText = paragraph.toLowerCase().replaceAll("[!?',;.]", " ");
        String[] words = sanitizedText.split("\\s+");
        for (String word : words) {
            map.merge(word, 1, Integer::sum);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a, b) -> b.getValue().compareTo(a.getValue()) // Сортировка по убыванию частоты
        );
        pq.addAll(map.entrySet());

        if (banned.length > 0) {
            Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
            while (!pq.isEmpty()) {
                Map.Entry<String, Integer> pair = pq.poll();
                String word = pair.getKey();
                if (!bannedSet.contains(word)) return word;
            }
        } else return pq.poll().getKey();

        return "";
    }

    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String paragraph1 = "a.";
        String[] ban = new String[]{"hit"};
        String[] ban1 = new String[0];
        System.out.println(mostCommonWord(paragraph1, ban1));
    }

}
