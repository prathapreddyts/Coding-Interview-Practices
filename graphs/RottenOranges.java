package graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        int minTime = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> nodeQueue = new LinkedList<>();

        // Enqueue all initially rotten oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {  // Fix 1: use cols, not rows
                if (grid[i][j] == 2) {
                    nodeQueue.add(new int[]{i, j});
                }
            }
        }

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            boolean rotted = false;
            for (int k = 0; k < size; k++) {
                int[] currentNode = nodeQueue.poll();
                for (int[] direction : directions) {
                    int newRow = currentNode[0] + direction[0];
                    int newCol = currentNode[1] + direction[1];
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols
                            && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;
                        nodeQueue.add(new int[]{newRow, newCol});
                        rotted = true;
                    }
                }
            }
            if (rotted) {
                minTime++;
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }

        return minTime;

    }
}
