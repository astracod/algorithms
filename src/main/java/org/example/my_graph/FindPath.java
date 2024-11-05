package org.example.my_graph;

import java.util.*;

public class FindPath {

    public static class Node {
        int value;                // Значение или идентификатор вершины
        boolean isOpen;           // Флаг, указывающий, была ли вершина посещена
        int distance;             // Расстояние от начальной вершины
        Node parent;
        List<Node> adjacency;

        public Node(int value) {
            this.value = value;
            this.isOpen = false;
            this.distance = 0;
            this.parent = null;
            this.adjacency = new ArrayList<>();
        }

        public void addNeighbor(Node neighbor) {
            adjacency.add(neighbor);
        }
    }

    public static boolean bfs(Node source, Node destination) {
        Queue<Node> queue = new LinkedList<>();
        source.distance = 0;
        source.isOpen = true;
        queue.add(source);
        while (!queue.isEmpty()) {
            Node u = queue.remove();
            if (u.value == destination.value) return true;

            for (Node v : u.adjacency) {
                if (!v.isOpen) {
                    v.isOpen = true;
                    v.distance = u.distance + 1;
                    v.parent = u;
                    queue.add(v);
                }
            }

        }
        return false;
    }

    public static boolean dfs(Node source, Node destination) {
        Stack<Node> stack = new Stack<>();
        stack.push(source);
        source.isOpen = true; // Отметить начальную вершину как посещённую
        source.distance = 0;   // Установить начальное расстояние

        while (!stack.isEmpty()) {
            Node u = stack.pop();

            // Проверка на совпадение
            if (u == destination) return true; // Путь найден

            // Обход соседей
            for (Node v : u.adjacency) {
                if (!v.isOpen) {
                    v.isOpen = true; // Отметить соседнюю вершину как посещённую
                    v.parent = u;     // Установить родителя
                    v.distance = u.distance + 1; // Обновить расстояние
                    stack.push(v);    // Добавить соседа в стек
                }
            }
        }

        return false; // Путь не найден
    }

    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodes.add(new Node(i));
        }
        for (int[] edge : edges) {
            nodes.get(edge[0]).addNeighbor(nodes.get(edge[1]));
            nodes.get(edge[1]).addNeighbor(nodes.get(edge[0]));
        }
        return bfs(nodes.get(source), nodes.get(destination));
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{{0, 1}, {1, 2}, {2, 0}};
        System.out.println(validPath(3, edges, 0, 2));
    }
}
