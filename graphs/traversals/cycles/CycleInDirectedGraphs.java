package graphs.traversals.cycles;

import java.util.*;

public class CycleInDirectedGraphs {
    public boolean isCyclic(int N, List<List<Integer>> adj) {
        boolean[] visited = new boolean[N];
        boolean[] recStack = new boolean[N];  // Tracks nodes in current DFS path
        // Check each node as potential starting point (handles disconnected graphs)
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, recStack)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int node, List<List<Integer>> adj, boolean[] visited, boolean[] recStack) {
        visited[node] = true;
        recStack[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, adj, visited, recStack)) {
                    return true;
                }
            } else if (recStack[neighbor]) {
                return true;
            }
        }
        recStack[node] = false;
        return false;
    }
    public boolean isCyclic(int N, List<Integer>[] adj) {
        boolean[] visited = new boolean[N];
        boolean[] inStack = new boolean[N]; // tracks nodes in current DFS path

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                if (hasCycleDirected(i, adj, visited, inStack)) {
                    return true;
                }
            }
        }

        return false;
    }

    // Iterative DFS to detect cycle in directed graph
    private boolean hasCycleDirected(int start, List<Integer>[] adj, boolean[] visited, boolean[] path) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Iterator<Integer>> iterMap = new HashMap<>();
        stack.push(start);
        iterMap.put(start, adj[start].iterator());
        visited[start] = true;
        path[start] = true;  // start node is now on the current path

        while (!stack.isEmpty()) {
            int current = stack.peek();
            Iterator<Integer> it = iterMap.get(current);  // get next unvisited neighbor
            if (it.hasNext()) {
                int neighbor = it.next();  // take only the next neighbor from iterator
                if (!visited[neighbor]) {
                    // unvisited neighbor — go deeper, add to path
                    stack.push(neighbor);
                    iterMap.put(neighbor, adj[neighbor].iterator());
                    visited[neighbor] = true;
                    path[neighbor] = true;  // neighbor is now on the current path
                } else if (path[neighbor]) {// neighbor already on current path — back edge, cycle detected
                    return true;
                }// visited but not on path — cross/forward edge, skip

            } else {
                // no more neighbors — backtrack, remove from current path
                stack.pop();
                path[current] = false;  // current node is leaving the current path
            }
        }

        return false;
    }

}
