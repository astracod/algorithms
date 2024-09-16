package org.example.my_graph;

import java.util.*;

public class MyGraph {
    public static class Node {
        int dist;
        boolean isOpen;
        int parent;
        List<Integer> adj;

        public Node() {
            this.dist = 0;
            this.isOpen = false;
            this.parent = -1;
            this.adj = new LinkedList<>();
        }
    }

    public MyGraph() {
    }

    public static void BFS(List<Node> a, int source) {
        a.get(source).isOpen = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            int u = queue.remove();
            for (int v : a.get(u).adj) {
                if (!a.get(v).isOpen) {
                    a.get(v).isOpen = true;
                    a.get(v).dist = a.get(u).dist + 1;
                    a.get(v).parent = u;
                    queue.add(v);
                }
            }
        }
    }

    public static void print(List<Node> graph) {
        for (int i = 0; i < graph.size(); i++) {
            System.out.print(i + "( "+ graph.get(i).parent+" "+graph.get(i).dist+" )");

            for (int i1 = 0; i1 < graph.get(i).adj.size(); i1++) {
                System.out.print(graph.get(i).adj.get(i1) + " ");
            }
            System.out.println();
        }

    }



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<Node> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new Node());
        }
        int m = scanner.nextInt();

        int x, y;
        for (int i = 1; i <= m; i++) {
            x = scanner.nextInt();
            y = scanner.nextInt();
            graph.get(x).adj.add(y);
            graph.get(y).adj.add(x);
        }

        BFS(graph, 1);
        print(graph);
    }
}
