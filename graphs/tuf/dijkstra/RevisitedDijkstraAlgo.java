package graphs.tuf.dijkstra;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class RevisitedDijkstraAlgo {

    public int[] dijkstra(int nodes, List<int[]>[] adj, int src) {
        int[] dist = new int[nodes];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<PairNode> pq = new PriorityQueue<>();
        pq.add(new PairNode(src, 0));
        dist[src] = 0;

        while (!pq.isEmpty()) {
            PairNode current = pq.poll();
            int currNode = current.node;
            int currDist = current.distance;

            for (int[] neighbor : adj[currNode]) {
                int nextNode = neighbor[0];
                int edgeWeight = neighbor[1];
                int newDist = currDist + edgeWeight;

                if (newDist < dist[nextNode]) {
                    dist[nextNode] = newDist;
                    pq.add(new PairNode(nextNode, newDist));
                }
            }
        }


        return dist;
    }
    public int[] dijkstraUsingSet(int nodes, List<int[]>[] adj, int src) {
        int[] dist = new int[nodes];
        Arrays.fill(dist, Integer.MAX_VALUE);

        return dist;
    }
}
