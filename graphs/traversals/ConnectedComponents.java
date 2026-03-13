package graphs.traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ConnectedComponents {
    public int findNumberOfComponent(int nNodes, List<List<Integer>> edges) {

        // Step 1: Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < nNodes; i++) {
            adj.add(new ArrayList<>());
        }
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u); // because undirected graph
        }
        // Step 2: visited array
        boolean[] visited = new boolean[nNodes];

        int count = 0;
        // Step 3: Traverse nodes
        for (int i = 0; i < nNodes; i++) {

            if (!visited[i]) {
                dfs(i, adj, visited);
                count++;
            }
        }
        return count;
    }

    private void bfs(int start, List<List<Integer>> adj, boolean[] visited) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbour : adj.get(node)) {

                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }
    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for (int neighbour : adj.get(node)) {
            if (!visited[neighbour]) {
                dfs(neighbour, adj, visited);
            }
        }
    }
}
