package graphs.interviewbit.graphtraversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PathDirectedGraph {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {

        // Step 1: Build adjacency list
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            adjList.add(new ArrayList<>());
        }

        for (ArrayList<Integer> edge : B) {
            int u = edge.get(0);
            int v = edge.get(1);
            adjList.get(u).add(v);
        }

        // Step 2: BFS
        boolean[] visited = new boolean[A + 1];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == A) {
                return 1;
            }

            for (int neighbour : adjList.get(current)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }

        return 0;
    }
}
