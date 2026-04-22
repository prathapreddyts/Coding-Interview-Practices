package graphs.tuf.cycles;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UndirectCycleInGraph {
    public boolean isCycle(int nodes, List<Integer>[] adj) {
        boolean[] visited = new boolean[nodes];
        Queue<int[]> nodeQueue = new LinkedList<>();
        for (int i = 0; i < nodes; i++) {
            if (!visited[i]) {
                nodeQueue.add(new int[]{i, -1});
                while (!nodeQueue.isEmpty()) {
                    int[] poll = nodeQueue.poll();
                    int node = poll[0];
                    int parentNode = poll[1];
                    for (Integer neighbour : adj[node]) {
                        if (!visited[neighbour]) {
                            visited[neighbour] = true;
                            nodeQueue.add(new int[]{neighbour, node});
                        } else if (visited[neighbour] && parentNode != neighbour) {
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    }

}
