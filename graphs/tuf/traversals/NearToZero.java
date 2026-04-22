package graphs.tuf.traversals;

import java.util.*;

public class NearToZero {
    public int[][] nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dist = new int[n][m];

        // Initialize with -1 (unvisited)
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }

        Queue<int[]> q = new LinkedList<>();

        // Step 1: Add all 1s
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    q.add(new int[]{i, j});
                    dist[i][j] = 0; // visited + distance
                }
            }
        }

        int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};

        // Step 2: BFS
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0];
            int c = cell[1];

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && dist[nr][nc] == -1) {
                    dist[nr][nc] = dist[r][c] + 1;
                    q.add(new int[]{nr, nc});
                }
            }
        }

        return dist;
    }
}
