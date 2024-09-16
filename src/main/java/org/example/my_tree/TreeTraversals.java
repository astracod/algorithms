package org.example.my_tree;

import java.util.*;

public class TreeTraversals {
    static class Node {
        String value;
        List<Node> children;

        public Node(String value) {
            this.value = value;
            this.children = new ArrayList<>();
        }

        public void addChild(Node child) {
            children.add(child);
        }
    }

    public static void bfs(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.value + " "); // Посетить узел

            for (Node child : current.children) {
                queue.add(child); // Добавить детей в очередь
            }
        }
    }

    public static void dfs(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.print(current.value + " "); // Посетить узел

            // Добавляем детей в стек в обратном порядке, чтобы они были посещены в правильном порядке
            for (int i = current.children.size() - 1; i >= 0; i--) {
                stack.push(current.children.get(i));
            }
        }
    }

    public static void main(String[] args) {
        // Создание узлов
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");
        Node G = new Node("G");
        Node H = new Node("H");

        // Построение дерева
        A.addChild(B);
        A.addChild(C);
        B.addChild(D);
        B.addChild(E);
        C.addChild(F);
        D.addChild(G);
        D.addChild(H);

        // Выполнение BFS
        System.out.println("BFS Traversal:");
        bfs(A); // Вывод: A B C D E F G H

        // Выполнение DFS
        System.out.println("\nDFS Traversal:");
        dfs(A); // Вывод: A B D G H E C F
    }

}
