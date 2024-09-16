package org.example.algorithms;

import java.util.*;

public class CloneGraph_138 {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    private Node cloneNodeRec(Node original, Map<Node, Node> visited) {
        // Проверка на null
        if (original == null) return null;

        // Проверка, был ли узел уже клонирован
        Node soughtFor = visited.get(original);
        if (soughtFor != null) return soughtFor;

        // Создание нового узла
        Node newNode = new Node(original.val);
        visited.put(original, newNode); // Сохранение клонированного узла в visited

        // Рекурсивное клонирование соседей
        for (Node neighbor : original.neighbors) {
            newNode.neighbors.add(cloneNodeRec(neighbor, visited)); // Рекурсивный вызов для соседей
        }

        return newNode; // Возврат клонированного узла
    }

    private Node cloneNode(Node original, Map<Node, Node> visited) {
        if (original == null) return null;

        Node soughtFor = visited.get(original);
        if (soughtFor != null) return soughtFor;

        Node newNode = new Node(original.val);
        visited.put(original, newNode);

        Stack<Node> stack = new Stack<>();
        stack.push(original);
        while (!stack.isEmpty()) {
            Node u = stack.pop();

            for (Node v : u.neighbors) {
                Node isCloned = visited.get(v);
                if (isCloned == null) {
                    Node neighborClone = new Node(v.val);
                    visited.put(v, neighborClone);
                    stack.push(v);
                }
                visited.get(u).neighbors.add(visited.get(v));
            }
        }

        return newNode;
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;

        Map<Node, Node> visited = new HashMap<>();
        return cloneNode(node, visited);
    }
}
