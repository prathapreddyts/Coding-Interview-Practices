package graphs.cycles;

import graphs.traversals.Pair;

import java.util.*;

public class CycleInDirectedGraphs {

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
    // Entry point — handles disconnected graphs
    public boolean hasCycleIterative(List<List<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];
        boolean[] path    = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfsStackIterator(i, adj, visited, path)) return true;
            }
        }
        return false;
    }

    // Iterative DFS using Stack + Iterator (mimics the call stack of recursive DFS)
    private boolean dfsStackIterator(int start, List<List<Integer>> adj,
                                     boolean[] visited, boolean[] path) {
        Stack<Pair> stack = new Stack<>();
        visited[start] = true;
        path[start] = true;                              // start is on current path
        stack.push(new Pair(start, adj.get(start).iterator()));

        while (!stack.isEmpty()) {
            Pair top = stack.peek();
            Iterator<Integer> it = top.getIterator();

            if (it.hasNext()) {
                int neighbor = it.next();

                if (!visited[neighbor]) {
                    // unvisited → go deeper
                    visited[neighbor] = true;
                    path[neighbor] = true;               // add to current path
                    stack.push(new Pair(neighbor, adj.get(neighbor).iterator()));
                } else if (path[neighbor]) {
                    // visited + on current path → back edge → cycle!
                    return true;
                }
                // visited + NOT on path → cross/forward edge, skip
            } else {
                // no more neighbours → backtrack
                path[top.getNode()] = false;             // remove from current path
                stack.pop();
            }
        }
        return false;
    }
    public boolean hasCycle(List<List<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];
        boolean[] path    = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, path)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int node, List<List<Integer>> adj,
                        boolean[] visited, boolean[] path) {
        visited[node] = true;
        path[node]    = true;

        for (int neighbour : adj.get(node)) {
            if (!visited[neighbour]) {
                if (dfs(neighbour, adj, visited, path)) return true;
            } else if (path[neighbour]) {   // back edge → cycle
                return true;
            }
        }

        path[node] = false;   // backtrack — leaving this node's DFS path
        return false;
    }

}
