package org.example.informatics;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Horse {

    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    static void printPath(Pair<Integer, Integer>[][] par, int x1, int y1, int x2, int y2) {
        if (!(x1 == x2 && y1 == y2)) {
            printPath(par, x1, y1, par[x2][y2].getKey(), par[x2][y2].getValue());
        }
        System.out.println((x2 + 1) + " " + (y2 + 1));
    }

    public static void findGrass(int[][] a, int n, int x1, int x2, int y1, int y2) {
        int vX, vY;
        Pair[][] par = new Pair[n][n];
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(x1, y1));
        a[x1][y1] = 0;
        int[][] shift = {{-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {-2, -1}, {-2, 1}, {2, -1}, {2, 1}};
        while (!q.isEmpty()) {
            Pair<Integer, Integer> u = q.poll();
            if (u.getKey() == x2 && u.getValue() == y2) break;
            for (int[] row : shift) {
                vX = u.getKey() + row[0];
                vY = u.getValue() + row[1];
                if (vX >= 0 && vX < n && vY >= 0 && vY < n && a[u.getKey()][u.getValue()] + 1 < a[vX][vY]) {
                    a[vX][vY] = a[u.getKey()][u.getValue()] + 1;
                    par[vX][vY] = new Pair<>(u.getKey(), u.getValue());
                    q.add(new Pair<>(vX, vY));
                }
            }
        }
        System.out.println(a[x2][y2]);
        printPath(par, x1, y1, x2, y2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = 2000000;
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        x1--;
        y1--;
        x2--;
        y2--;
        findGrass(a, n, x1, x2, y1, y2);
    }


}
