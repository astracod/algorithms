package org.example.algorithms;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // Инициализация списка смежности
        List<Integer>[] adjacency = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjacency[i] = new ArrayList<>();
        }

        // Инициализация массива состояния
        int[] state = new int[numCourses]; // 0 - не посещен, 1 - в процессе, 2 - посещен

        // Заполнение списка смежности
        for (int i = 0; i < prerequisites.length; i++) {
            int ai = prerequisites[i][0]; // курс, который нужно пройти
            int bi = prerequisites[i][1]; // пререквизит для курса ai
            adjacency[bi].add(ai); // добавляем ai в список смежности курса bi
        }

        // Проверка каждого курса
        for (int course = 0; course < numCourses; course++) {
            if (state[course] == 0) { // Если курс не посещен
                if (!dfs(state, adjacency, course)) {
                    return false; // Если обнаружен цикл
                }
            }
        }

        return true; // Все курсы могут быть пройдены
    }

    private static boolean dfs(int[] state, List<Integer>[] graph, int course) {
        // Если курс в процессе посещения, это цикл
        if (state[course] == 1) {
            return false;
        }
        // Если курс уже посещен, ничего не делаем
        if (state[course] == 2) {
            return true;
        }

        // Устанавливаем курс в состояние "в процессе посещения"
        state[course] = 1;

        // Проходим по всем соседям (пререквизитам)
        for (int neighbor : graph[course]) {
            if (!dfs(state, graph, neighbor)) {
                return false; // Если обнаружен цикл
            }
        }

        // Устанавливаем курс в состояние "посещен"
        state[course] = 2;
        return true; // Успешно обработан
    }



    public static void main(String[] args) {
        // Примеры тестов
        System.out.println(canFinish(4, new int[][]{{1, 0}, {2, 1}, {3, 2}})); // true
        System.out.println(canFinish(2, new int[][]{{1, 0}, {0, 1}})); // false
        System.out.println(canFinish(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}})); // true
        System.out.println(canFinish(3, new int[][]{{0, 1}, {0, 2}})); // true
    }

}
