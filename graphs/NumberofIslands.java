package graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class NumberofIslands {
    public int numIslands(char[][] grid) {
        return bfsHelper(grid);
    }

    public int bfsHelper(char[][] grid) {

        int count = 0;
        int r = grid.length;
        int c = grid[0].length;

        int[][] directions = {
                {1, 0}, {-1, 0}, {0, 1}, {0, -1},
                {1, 1}, {-1, -1}, {-1, 1}, {1, -1}
        };

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {

                if (grid[i][j] == '1') {
                    count++;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] node = queue.poll();
                        int row = node[0];
                        int col = node[1];
                        if (grid[row][col] == '0') continue;
                        grid[row][col] = '0';
                        for (int[] dir : directions) {
                            int newRow = row + dir[0];
                            int newCol = col + dir[1];
                            if (newRow >= 0 && newRow < r &&
                                    newCol >= 0 && newCol < c &&
                                    grid[newRow][newCol] == '1') {
                                queue.add(new int[]{newRow, newCol});
                            }
                        }
                    }
                }
            }
        }

        return count;
    }
}
