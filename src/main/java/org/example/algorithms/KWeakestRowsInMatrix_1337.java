package org.example.algorithms;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KWeakestRowsInMatrix_1337 {
    public static int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int i1 : mat[i]){
                if (i1 == 1) count += i1;
                else break;
            }
            pq.add(new int[]{count, i});
        }

        int[] res = new int[k];
        for (int i = 0; i < res.length; i++) {
            res[i] = pq.poll()[1];
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][]{{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}};
        int[][] mat1 = new int[][]{{1, 0, 0, 0}, {1, 1, 1, 1}, {1, 0, 0, 0}, {1, 0, 0, 0}};
        System.out.println(Arrays.toString(kWeakestRows(mat, 3)));
    }
}
