package org.example.algorithms;

import java.util.*;

public class DFS {

    public static int[] dfs(List<List<Integer>> adjacencyList, boolean[] visited, int vertex, int numVertices) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[numVertices];
        stack.push(vertex);
        visited[vertex] = true;
        int i = 0;
        while (!stack.isEmpty()) {
            int u = stack.pop();
            res[i] = u;
            i++;
            //  Добавляем в обратном порядке, что бы вывести в возрастающем порядке
            for (int j = adjacencyList.get(u).size() - 1; j >= 0; j--) {
                Integer v = adjacencyList.get(u).get(j);
                if (!visited[v]) {
                    visited[v] = true;
                    stack.push(v);
                }
            }
        }
        return res;
    }

    public static int[] bfs(List<List<Integer>> adjacencyList, boolean[] visited, int startVertex, int numVertices) {
        Queue<Integer> queue = new LinkedList<>();
        int[] res = new int[numVertices];
        queue.offer(startVertex);
        visited[startVertex] = true;
        int i = 0;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            res[i] = u;
            i++;

            for (Integer v : adjacencyList.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int numVertices = 5;

        // Создание списка смежности
        List<List<Integer>> adjacencyList = new ArrayList<>(numVertices);
        boolean[] visited = new boolean[numVertices];
        boolean[] visitedBFS = new boolean[numVertices];

        // Инициализация списка смежности
        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Добавление рёбер в граф
        adjacencyList.get(0).add(1);
        adjacencyList.get(0).add(4);
        adjacencyList.get(1).add(0);
        adjacencyList.get(1).add(2);
        adjacencyList.get(1).add(3);
        adjacencyList.get(1).add(4);
        adjacencyList.get(2).add(1);
        adjacencyList.get(2).add(3);
        adjacencyList.get(3).add(1);
        adjacencyList.get(3).add(2);
        adjacencyList.get(3).add(4);
        adjacencyList.get(4).add(0);
        adjacencyList.get(4).add(1);
        adjacencyList.get(4).add(3);

        // Вывод списка смежности
        for (int i = 0; i < adjacencyList.size(); i++) {
            System.out.print(i + " -> ");
            for (int neighbor : adjacencyList.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }

        int[] r = dfs(adjacencyList, visited, 0,numVertices);
        System.out.println(Arrays.toString(r));
        int[] q = bfs(adjacencyList,visitedBFS,0,numVertices);
        System.out.println(Arrays.toString(q));
    }
}
