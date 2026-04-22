package graphs.tuf.hardproblems;

import graphs.tuf.traversals.Pair;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class EventualSafeStates {
    public static void main(String[] args) {
        System.out.println('a'-'a');
    }

    // Function to get the eventually safe nodes
    public int[] eventualSafeNodesUsingRec(int V, int[][] adj) {
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];
        boolean[] check = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfsCheck(i, adj, vis, pathVis, check);
            }
        }
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (check[i])
                temp.add(i);
        }
        int[] ans = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            ans[i] = temp.get(i);
        }
        return ans;
    }

    private boolean dfsCheck(int node, int[][] adj,
                             boolean[] vis,
                             boolean[] pathVis,
                             boolean[] check) {
        vis[node] = true;
        pathVis[node] = true;
        check[node] = false;
        for (int it : adj[node]) {
            if (!vis[it]) {
                if (dfsCheck(it, adj, vis, pathVis, check)) {
                    return true;
                }
            } else if (pathVis[it]) {
                return true;
            }
        }
        check[node] = true;
        pathVis[node] = false;
        return false;
    }


    public int[] eventualSafeNodes(int nodes, int[][] adj) {

        boolean[] path = new boolean[nodes];
        boolean[] safe = new boolean[nodes];
        boolean[] visited = new boolean[nodes];

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nodes; i++) {
            if (visited[i]) continue;

            Stack<Pair> stack = new Stack<>();
            stack.push(new Pair(i, getIterator(adj[i])));
            path[i] = true;

            while (!stack.isEmpty()) {
                Pair top = stack.peek();
                int node = top.node;
                Iterator<Integer> it = top.iterator;

                if (it.hasNext()) {
                    int neighbor = it.next();

                    if (path[neighbor]) {
                        safe[neighbor] = false;
                        continue;
                    }

                    if (!visited[neighbor]) {
                        path[neighbor] = true;
                        stack.push(new Pair(neighbor, getIterator(adj[neighbor])));
                    }

                } else {
                    stack.pop();
                    path[node] = false;
                    visited[node] = true;

                    // ✅ Check if all neighbors are safe
                    boolean isSafe = true;
                    for (int nei : adj[node]) {
                        if (!safe[nei]) {
                            isSafe = false;
                            break;
                        }
                    }
                    safe[node] = isSafe;
                }
            }
        }

        for (int i = 0; i < nodes; i++) {
            if (safe[i]) result.add(i);
        }

        return result.stream().mapToInt(x -> x).toArray();
    }

    private Iterator<Integer> getIterator(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int x : arr) list.add(x);
        return list.iterator();
    }
}
