package org.example.algorithms;

public class ToeplitzMatrix_766 {
    public static boolean isToeplitzMatrix(int[][] matrix) {
        int i = 1, j = 1;
        if (matrix.length > 0 && matrix[i].length == 1) return true;
        while (i < matrix.length) {
            System.out.println(matrix[i - 1][j - 1] + " " + matrix[i][j] + " " + i + " " + j);
            if (matrix[i - 1][j - 1] != matrix[i][j]) {
                return false;
            } else if (j < matrix[i].length - 1) {
                j++;
            } else {
                i++;
                j = 1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        int[][] matrix1 = new int[][]{{1, 2}, {2, 2}};
        int[][] matrix2 = new int[][]{{11, 74, 0, 93}, {40, 11, 74, 7}};
        int[][] matrix3 = new int[][]{{97, 97}, {80, 6}, {10, 79}};
        int[][] matrix4 = new int[][]{{18}, {66}};
        int[][] matrix5 = new int[][]{{36, 59, 71, 15, 26, 82, 87}, {56, 36, 59, 71, 15, 26, 82}, {15, 0, 36, 59, 71, 15, 26}};
        System.out.println(isToeplitzMatrix(matrix5));
    }
}
