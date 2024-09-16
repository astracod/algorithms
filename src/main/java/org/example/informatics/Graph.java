package org.example.informatics;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Graph {
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

    public Graph() {
    }

    public static void BFS(int[][] a, int source, int [] parentArray) {
        boolean [] isOpen = new boolean[a.length];
        isOpen[source] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            int u = queue.remove();
            for (int v = 0; v < a.length; v++) {
                if(a[u][v]==1 && isOpen[v]==false) {
                    isOpen[v] = true;
                    //dist[v] = dist[u] + 1;
                    parentArray[v] = u;
                    queue.add(v);
                }
            }
        }
    }

    static void printPath(int [] parentArray, int source, int finish) {
        if(finish!=source)
            printPath(parentArray, source, parentArray[finish]);
        System.out.print((finish+1) + " ");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                graph[i][j] = scanner.nextInt();
        int source = scanner.nextInt();
        int finish = scanner.nextInt();
        source--;
        finish--;
        int [] parentArray = new int[graph.length];
        for (int i = 0; i < n; i++)
            parentArray[i] = -1;

        BFS(graph, source, parentArray);

        printPath(parentArray, source, finish);
    }
}
