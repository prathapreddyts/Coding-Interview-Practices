package graphs.traversals;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFillAlgorithm {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int row = image.length;
        int col = image[0].length;
        int orgColor = image[sr][sc];
        boolean sameColour = image[sr][sc] == newColor;
        if (sameColour) {
            return image;
        }
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        Queue<int[]> nodeQueue = new LinkedList<>();
        nodeQueue.add(new int[]{sr, sc});
        image[sr][sc] = newColor;
        while (!nodeQueue.isEmpty()) {
            int[] currentNode = nodeQueue.poll();
            int currentRow = currentNode[0];
            int currentCol = currentNode[1];

            for (int[] direction : directions) {
                int newRowDirection = direction[0] + currentRow;
                int newColDirection = direction[1] + currentCol;

                if ((newRowDirection >= 0 && newRowDirection < row) && (newColDirection >= 0 && newColDirection < col) && image[newRowDirection][newColDirection] == orgColor) {
                    image[newRowDirection][newColDirection] = newColor;
                    nodeQueue.add(new int[]{newRowDirection, newColDirection});
                }
            }
        }
        return image;
    }
}
