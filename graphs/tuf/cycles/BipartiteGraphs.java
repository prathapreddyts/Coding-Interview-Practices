package graphs.tuf.cycles;

import graphs.tuf.traversals.Pair;

import java.util.*;

public class BipartiteGraphs {
    public boolean isBipartite(int nodes, List<List<Integer>> adj) {
        int[] colored = new int[nodes];
        Arrays.fill(colored, -1);

        for (int i = 0; i < nodes; i++) {
            if (colored[i] == -1) {
                if (!isBipartiteHelper(i, adj, colored)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartiteHelper(int startNode, List<List<Integer>> adj, int[] colored) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(startNode);
        colored[startNode] = 0; // start with color 0

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : adj.get(current)) {

                // If not colored → assign opposite color
                if (colored[neighbor] == -1) {
                    colored[neighbor] = 1 - colored[current];
                    queue.add(neighbor);
                }
                // If same color → not bipartite
                else if (colored[neighbor] == colored[current]) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isBipartiteUsingDFS(int nodes, List<List<Integer>> adj) {

        int[] colored = new int[nodes];
        Arrays.fill(colored, -1);
        Stack<Pair> stack = new Stack<>();
        for (int i = 0; i < nodes; i++) {
            if (colored[i] == -1) {
                // start new component
                stack.push(new Pair(i, adj.get(i).iterator()));
                colored[i] = 0; // ✅ assign color on entry

                while (!stack.isEmpty()) {
                    Pair top = stack.peek();
                    int node = top.getNode();
                    Iterator<Integer> it = top.getIterator();
                    if (it.hasNext()) {
                        int neighbor = it.next();
                        // 🔹 If not colored → assign opposite and go deeper
                        if (colored[neighbor] == -1) {
                            colored[neighbor] = 1 - colored[node];
                            stack.push(new Pair(neighbor, adj.get(neighbor).iterator()));
                        }
                        // 🔹 If already colored and same → conflict
                        else if (colored[neighbor] == colored[node]) {
                            return false;
                        }
                    } else {
                        // DFS backtrack (same as topo template)
                        stack.pop();
                    }
                }
            }
        }

        return true;
    }
}
