package org.example.informatics;

import java.util.Scanner;


public class Roads {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] roads = new int[n][n];
        for (int i = 0; i < roads.length; i++) {
            for (int i1 = 0; i1 < roads.length; i1++) {
                int m = scanner.nextInt();
                roads[i][i1] = m;
            }
        }
        int a = citiesAndRoads(roads);
        System.out.println(a);
    }
    public static int citiesAndRoads(int[][] roads) {
        int amountOfRoads = 0;
        for (int i = 0; i < roads.length; i++) {
            for (int i1 = 0; i1 < roads[i].length; i1++) {
                if (roads[i][i1] == 1) {
                    amountOfRoads++;
                }
            }
        }
        return amountOfRoads / 2;
    }
}