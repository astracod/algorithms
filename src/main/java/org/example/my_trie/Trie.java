package org.example.my_trie;

import java.util.*;

public class Trie {
    public static class TrieNode {
        TrieNode[] children = new TrieNode[26]; // Для 26 символов латинского алфавита
        boolean isEndOfWord; // Является ли конец этого узла концом слова
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a'; // Вычисляем индекс для текущей буквы

            // Если ссылки по этому индексу еще нет, создаем новый узел
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            // Переходим к следующему узлу
            current = current.children[index];
        }

        // Отмечаем последний узел как конец слова
        current.isEndOfWord = true;
    }

    // Метод для вывода всех слов в Trie
    public List<String> getAllWords() {
        List<String> result = new ArrayList<>();
        collectWords(root, "", result);
        return result;
    }

    // Рекурсивный вспомогательный метод для сбора слов
    private void collectWords(TrieNode node, String prefix, List<String> result) {
        if (node.isEndOfWord) {
            result.add(prefix); // Добавляем текущее слово в результат
        }

        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                char nextChar = (char) (i + 'a'); // Восстанавливаем символ
                collectWords(node.children[i], prefix + nextChar, result); // Рекурсивно идем глубже
            }
        }
    }

    public String longestCommonPrefix(String[] strs) {
        for (String str : strs) {
            insert(str);
        }
        StringBuilder prefix = new StringBuilder();
        TrieNode current = root;

        while (true) {
            // Считаем количество дочерних узлов
            int childrenCount = 0;
            int childIndex = -1;

            for (int i = 0; i < 26; i++) {
                if (current.children[i] != null) {
                    childrenCount++;
                    childIndex = i;
                }
            }

            // Если есть более одного дочернего узла или узел - конец слова, прекращаем
            if (childrenCount != 1 || current.isEndOfWord) {
                break;
            }

            // Добавляем символ к префиксу и идем глубже по единственному дочернему узлу
            current = current.children[childIndex];
            prefix.append((char) (childIndex + 'a'));
        }

        if (!prefix.isEmpty()) return prefix.toString();
        else return "";
    }

}

class Main {

    public static int lengthOfLastWord(String s) {
        String a = s.replaceAll("\\s+", " ");
        String[] arr = a.split(" ");
        return arr[arr.length - 1].length();
    }

    public static boolean isPalindrome(String s) {
        if (s.equals(" ")) return true;
        String lowerCase = s.replaceAll("[\\p{Punct}\\s]+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < lowerCase.length(); i++) {
            stack.push(lowerCase.charAt(i));
        }
        for (int i = 0; i < lowerCase.length(); i++) {
            char character = stack.pop();
            if (character != lowerCase.charAt(i)) return false;
        }
        return true;
    }

    public static boolean wordPattern(String pattern, String s) {
        Map<String, Character> map = new HashMap<>();
        String[] substrings = s.split("\\s+");
        Set<Character> values = new HashSet<>();
        if (pattern.length() != substrings.length) return false;
        for (int i = 0; i < substrings.length; i++) {
            Character value = map.get(substrings[i]);
            if (value == null && !values.contains(pattern.charAt(i))) {
                map.put(substrings[i], pattern.charAt(i));
                values.add(pattern.charAt(i));
            } else if (value == null && values.contains(pattern.charAt(i)) ||
                    (value != null && value != pattern.charAt(i))) return false;

        }
        return true;
    }

    public static void reverseString(char[] s) {
        int max = s.length - 1;
        for (int i = 0; i < s.length / 2; i++) {
            char buf = s[i];
            s[i] = s[max];
            s[max] = buf;
            max--;
        }
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> r = new HashMap<>();
        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            r.merge(ransomNote.charAt(i), 1, Integer::sum);
        }
        for (int i = 0; i < magazine.length(); i++) {
            m.merge(magazine.charAt(i), 1, Integer::sum);
        }
        if (m.size() < r.size()) return false;
        for (Map.Entry<Character, Integer> entry : r.entrySet()) {
            Integer amount = m.get(entry.getKey());
            if (amount == null || amount < entry.getValue()) return false;
        }
        return true;
    }

    public static void removeEverySecondElement(List<String> list) {
        int count = 1;
        for (int i = 0; i < list.size(); i++) {
            if (i == count) {
                list.remove(i);
                count++;
            }
        }
    }

    /**
     * происходит изменение флага на противоположное значение, что позволяет удалять через одного
     *
     * @param list
     */
    public static void removeEverySecondElementWithoutCounter(List<String> list) {
        boolean remove = false;
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            if (remove) {
                iterator.remove();
            }
            remove = !remove;
        }
    }

    public static int countSegments(String s) {
        if (s.length() == 0) return 0;
        String[] substrings = s.trim().split("\\s+");
        return (int) Arrays.stream(substrings)
                .filter(word -> !word.isEmpty())
                .count();
    }

    /**
     * Проверка состоит ли строка только и подстрок-последовательностей.
     * @param s
     * @return
     */
    public static boolean repeatedSubstringPattern(String s) {
        if (s.length() < 2) return false;
        StringBuilder builder = new StringBuilder(s+s);
        builder.deleteCharAt(0).deleteCharAt(builder.length()-1);
        return builder.toString().contains(s);
    }

    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(repeatedSubstringPattern(s));
    }
}

