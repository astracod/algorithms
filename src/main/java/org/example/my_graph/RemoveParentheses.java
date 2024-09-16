package org.example.my_graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveParentheses {

    public static List<String> removeInvalidParentheses(String s) {
        int[] count = countInvalidParentheses(s);
        Set<String> result = new HashSet<>();
        backtrack(s, 0, count[0], count[1], result);
        return new ArrayList<>(result);
    }

    private static int[] countInvalidParentheses(String s) {
        int leftToRemove = 0, rightToRemove = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                leftToRemove++;
            } else if (ch == ')') {
                if (leftToRemove > 0) {
                    leftToRemove--;
                } else {
                    rightToRemove++;
                }
            }
        }
        return new int[]{leftToRemove, rightToRemove};
    }

    private static void backtrack(String s, int start, int leftToRemove, int rightToRemove, Set<String> result) {
        if (leftToRemove == 0 && rightToRemove == 0) {
            if (isValid(s)) {
                result.add(s);
            }
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (i > start && s.charAt(i) == s.charAt(i - 1)) {
                continue; // Пропускаем дубликаты
            }
            if (leftToRemove > 0 && s.charAt(i) == '(') {
                // Удаляем открывающую скобку
                backtrack(s.substring(0, i) + s.substring(i + 1), i, leftToRemove - 1, rightToRemove, result);
            }
            if (rightToRemove > 0 && s.charAt(i) == ')') {
                // Удаляем закрывающую скобку методом строк (s.substring(0, i) + s.substring(i + 1)).
                // Элемент i выпадает из новой строки, s.substring(0, i) вырезает от 0 до i не включая.
                // s.substring(i + 1) вырезает от i+1 до конца.
                backtrack(s.substring(0, i) + s.substring(i + 1), i, leftToRemove, rightToRemove - 1, result);
            }
        }
    }

    private static boolean isValid(String s) {
        int balance = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                balance++;
            } else if (ch == ')') {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }


}
