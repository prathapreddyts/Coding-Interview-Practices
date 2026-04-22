package graphs.tuf.traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SourceToDestination {
    public static void main(String[] args) {
        int[]inp={1,1,2};
        solve(inp,2,1);
    }
    public static int solve(int[] A, int B, int C) {
        int n = A.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        // here we started from index 1 because inorder to avoid self loop
        //A[0]=1 as give if loop starts from 0->n nodes map is 0->1 this results 1->1 self loop
        for (int i = 1; i < n; i++) {
            adj.get(A[i]).add(i + 1);
        }
        System.out.println(adj);
        boolean[] visited = new boolean[n + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(C);
        visited[C] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node == B) {
                return 1;
            }
            for (int neighbour : adj.get(node)) {
                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }
        return 0;
    }
}



