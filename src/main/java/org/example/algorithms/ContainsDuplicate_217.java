package org.example.algorithms;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate_217 {
    /**
     * метод add() для интерфейса Set добавляет элемент в коллекцию, если его там еще нет.
     * Если же элемент уже присутствует, метод не изменяет коллекцию и возвращает false.
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
