package graphs.hardproblems;

import graphs.traversals.Pair;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class EventualSafeStates {
    public int[] eventualSafeNodes(int V, int[][] adj) {

        boolean[] path = new boolean[V];    // recursion stack
        boolean[] safe = new boolean[V];    // safe nodes
        boolean[] visited = new boolean[V]; // processed

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (visited[i]) continue;
            Stack<Pair> stack = new Stack<>();
            stack.push(new Pair(i, getIterator(adj[i])));
            path[i] = true;

            boolean isSafeComponent = true;
            while (!stack.isEmpty()) {
                Pair top = stack.peek();
                int node = top.node;
                Iterator<Integer> it = top.iterator;
                if (it.hasNext()) {
                    int neighbor = it.next();
                    if (path[neighbor]) {
                        isSafeComponent = false;
                        break;
                    }
                    if (!visited[neighbor]) {
                        path[neighbor] = true;
                        stack.push(new Pair(neighbor, getIterator(adj[neighbor])));
                    }
                } else {
                    stack.pop();
                    path[node] = false;
                    visited[node] = true;
                    if (isSafeComponent) {
                        safe[node] = true;
                    }
                }
            }
            if (!isSafeComponent) {
                while (!stack.isEmpty()) {
                    int node = stack.pop().node;
                    path[node] = false;
                    visited[node] = true;
                }
            }
        }
        for (int i = 0; i < V; i++) {
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
