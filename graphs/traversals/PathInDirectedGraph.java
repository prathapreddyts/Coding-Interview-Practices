package graphs.traversals;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PathInDirectedGraph {
    public int solve(int A, int[][] B) {

        List<List<Integer>> adj = new ArrayList<>(A + 1);

        for (int i = 0; i <= A; i++)
            adj.add(new ArrayList<>());
        for (int[] e : B)
            adj.get(e[0]).add(e[1]);
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[A + 1];
        q.add(1);
        visited[1] = true;
        while (!q.isEmpty()) {
            int node = q.poll();
            if (node == A)
                return 1;
            for (int nei : adj.get(node)) {
                if (!visited[nei]) {
                    visited[nei] = true;
                    q.offer(nei);
                }
            }
        }

        return 0;
    }

    public int solveUsingStreams(int A, int[][] B) {

        List<List<Integer>> adj =
                IntStream.rangeClosed(0, A)
                        .mapToObj(i -> new ArrayList<Integer>())
                        .collect(Collectors.toList());

        Arrays.stream(B)
                .forEach(edge -> adj.get(edge[0]).add(edge[1]));

        boolean[] visited = new boolean[A + 1];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        visited[1] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node == A) {
                return 1;
            }
            adj.get(node)
                    .stream()
                    .filter(neighbour -> !visited[neighbour])
                    .forEach(neighbour -> {
                        visited[neighbour] = true;
                        queue.offer(neighbour);
                    });
        }

        return 0;
    }
}
