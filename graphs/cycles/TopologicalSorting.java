package graphs.cycles;

import graphs.traversals.Pair;

import java.util.*;

public class TopologicalSorting {

    // BFS - Kahn's Algorithm
    // Graph: 0->{1,2}, 1->{3}, 2->{3}, 3->{}
    // inDegree: [0, 1, 1, 2]
    // Queue starts with nodes having inDegree 0 → [0]
    // Process 0 → reduce neighbors 1,2 → inDegree:[0,0,0,2] → Queue:[1,2]
    // Process 1 → reduce neighbor 3  → inDegree:[0,0,0,1] → Queue:[2]
    // Process 2 → reduce neighbor 3  → inDegree:[0,0,0,0] → Queue:[3]
    // Process 3 → no neighbors       → Queue:[]
    // Result: [0, 1, 2, 3]
    public int[] topoSortUsingBFS(int nodes, List<List<Integer>> adj) {

        // Step 1: Calculate in-degree for every node
        // in-degree = how many edges are coming INTO this node
        int[] inDegree = new int[nodes];
        for (int i = 0; i < nodes; i++) {
            for (int neighbour : adj.get(i)) {
                inDegree[neighbour]++;
            }
        }
        // Step 2: Push all nodes with in-degree 0 into the queue
        // These nodes have no dependency, so they can go first
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nodes; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        // Step 3: BFS - process nodes level by level
        int[] topoOrder = new int[nodes];
        int index = 0;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();          // pick a node with inDegree 0
            topoOrder[index++] = currentNode;        // add it to result
            // For each neighbour, reduce its in-degree by 1
            // (we are "removing" currentNode from the graph)
            for (int neighbour : adj.get(currentNode)) {
                inDegree[neighbour]--;
                // If neighbour now has no remaining dependencies, enqueue it
                if (inDegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }
        return topoOrder;
    }

    public int[] topSortUsingDFS(int nodes, List<List<Integer>> adj) {

        boolean[] visited = new boolean[nodes];
        // Use List — add(0, value) inserts at front (index 0)
        // so when a node finishes (post-order), it naturally goes to the front
        // → no manual reversal needed at the end
        List<Integer> topoResult = new ArrayList<>();

        Stack<Pair> recursiveStack = new Stack<>();
        for (int i = 0; i < nodes; i++) {
            if (!visited[i]) {
                recursiveStack.push(new Pair(i, adj.get(i).iterator()));
                visited[i] = true; // ✅ mark on entry
                while (!recursiveStack.isEmpty()) {
                    Pair peekNode = recursiveStack.peek();
                    Iterator<Integer> it = peekNode.getIterator();
                    if (it.hasNext()) {
                        int neighbour = it.next();
                        if (!visited[neighbour]) {
                            visited[neighbour] = true; // ✅ mark here
                            recursiveStack.push(
                                    new Pair(neighbour, adj.get(neighbour).iterator())
                            );
                        }
                    } else {
                        // post-order: node fully processed → insert at index 0 (front)
                        // add(0, value) replaces the old manual reversal loop
                        Pair node = recursiveStack.pop();
                        topoResult.add(0, node.getNode());
                    }
                }
            }
        }

        // Convert list to int[] (already in correct topo order, no reversal needed)
        int[] topsortOrder = new int[nodes];
        int index = 0;
        for (int node : topoResult) {
            topsortOrder[index++] = node;
        }
        return topsortOrder;
    }

    public int[] topSortUsingDFSRecursive(int nodes, List<List<Integer>> adj) {
        int[] toposortAns = new int[nodes];
        Stack<Integer> topoStack = new Stack<>();
        boolean[] visited = new boolean[nodes];
        for (int i = 0; i < nodes; i++) {
            dfsHelper(i, adj, visited, topoStack);
        }
        int index = 0;
        while (!topoStack.isEmpty()) {
            toposortAns[index++] = topoStack.pop();
        }
        return toposortAns;
    }

    public void dfsHelper(int currentNode, List<List<Integer>> adj, boolean[] visited, Stack<Integer> topoStack) {
        visited[currentNode] = true;
        for (int neightbourNode : adj.get(currentNode)) {
            if (visited[neightbourNode] == false) {
                dfsHelper(neightbourNode, adj, visited, topoStack);
            }
        }
        topoStack.push(currentNode);
    }
}
