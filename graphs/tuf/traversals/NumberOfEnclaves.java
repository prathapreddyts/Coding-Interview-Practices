package graphs.tuf.traversals;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {

    public int numberOfEnclaves(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1) {
                    if (grid[i][j] == 1) {
                        queue.add(new int[]{i, j});
                        grid[i][j] = 0; // mark visited
                    }
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            for (int[] d : directions) {
                int r = node[0] + d[0];
                int c = node[1] + d[1];

                if (r >= 0 && c >= 0 && r < rows && c < cols && grid[r][c] == 1) {
                    queue.add(new int[]{r, c});
                    grid[r][c] = 0; // mark visited
                }
            }
        }
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1)
                    count++;
            }
        }

        return count;
    }
}

