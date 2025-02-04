package org.example.algorithms;

import java.util.Arrays;

public class ReshapeTheMatrix_566 {

    // мое решение 1 ms
    public int[][] matrixReshape2(int[][] mat, int r, int c) {
        int n = mat.length * mat[0].length;
        if (n != r * c) return mat;
        int[][] res = new int[r][c];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                int k = mat[i].length * i + j;
                res[k / c][k % c] = mat[i][j];
            }
        }
        return res;
    }

    // лучшее решение 0 ms
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }

        int[][] reshaped = new int[r][c];
        int row = 0, col = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                reshaped[row][col] = mat[i][j];
                col++;
                if (col == c) {
                    col = 0;
                    row++;
                }
            }
        }

        return reshaped;
    }
    public static void main(String[] args) {
        int[][] mat = new int[][]{{1, 2}, {3, 4}};
        int[][] res = matrixReshape(mat, 1, 4);
        for (int[] ints : res) {
            System.out.println(Arrays.toString(ints));
        }

    }
}
