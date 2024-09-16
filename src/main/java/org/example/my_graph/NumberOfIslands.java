package org.example.my_graph;


public class NumberOfIslands {

    public void dfs(char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0') {
            return;
        }
        int[][] checkPoints = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        grid[x][y] = '0';
        for (int[] checkPoint : checkPoints) {
            dfs(grid, x + checkPoint[0], y + checkPoint[1]);
        }
    }

    public int numIslands(char[][] grid) {
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
    }

    public static void main(String[] args) throws InterruptedException {
        NumberOfIslands number = new NumberOfIslands();
        char[][] grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};

        System.out.println(number.numIslands(grid));

    }
}
