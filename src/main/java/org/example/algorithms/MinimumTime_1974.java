package org.example.algorithms;

public class MinimumTime_1974 {
    /**
     * Модульность полезна при вычислении кольца, так как она обеспечивает замкнутость операций через остаток от деления,
     * гарантируя, что результаты всегда остаются в пределах кольца.
     */
    public static int minTimeToType(String word) {
        if (word.length() == 1) return 0;
        int last = 0;
        int sum = 0;
        for (int i = 0; i < word.toCharArray().length; i++) {
            int current = word.charAt(i) - 'a';
            int right = (current - last + 26) % 26;
            int left = (last - current + 26) % 26;
            sum += Math.min(right, left) + 1;
            last = current;
        }
        return sum;
    }

    public static int minTimeToTypeFromHint(String word) {
        int result = word.length(), prev = 'a';
        for (char c : word.toCharArray()) {
            int diff = Math.abs(c - prev); // вправо по кольцу
            int anotherWay = 26 - diff; // влево по кольцу
            // прибавляем к длине слова - result, чтобы сразу учесть момент добавления каждого символа
            result += Math.min(diff, anotherWay);
            prev = c;
        }
        return result;
    }

    public static void main(String[] args) {
        String word = "abc";
        String word1 = "bza";
        String word2 = "zjpc";
        System.out.println(minTimeToTypeFromHint(word));
    }
}
