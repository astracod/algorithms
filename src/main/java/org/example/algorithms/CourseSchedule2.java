package org.example.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class CourseSchedule2 {


    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjacency = new ArrayList[numCourses];
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjacency[i] = new ArrayList<>();
        }

        for (int[] prerequisite : prerequisites) {
            adjacency[prerequisite[1]].add(prerequisite[0]);
            inDegree[prerequisite[0]]++;
        }

        return iterativeDFS(adjacency, inDegree, numCourses);
    }

    private static int[] iterativeDFS(List<Integer>[] adjacency, int[] inDegree, int numCourses) {
        Stack<Integer> courses = new Stack<>();
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                courses.push(i);
                visited[i] = true;
            }
        }
        while (!courses.isEmpty()) {
            int u = courses.pop();
            result.add(u);
            visited[u] = true;
            for (Integer v : adjacency[u]) {
                inDegree[v]--;
                if (inDegree[v] == 0){
                    visited[v] = true;
                    courses.push(v);
                }
            }
        }

        if (result.size() != numCourses) return new int[0];
        else return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] r = findOrder(4, prerequisites);
        System.out.println(Arrays.toString(r));
    }
}
