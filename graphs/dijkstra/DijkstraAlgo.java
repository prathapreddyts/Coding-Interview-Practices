package graphs.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgo {

    // Each entry in adj: [neighborNode, edgeWeight]
    public int[] dijkstra(int nodes, List<int[]>[] adj, int src) {
        int[] dist = new int[nodes];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // PriorityQueue ordered by distance (min-heap) using PairNode's comparator
        PriorityQueue<PairNode> pq = new PriorityQueue<>(new PairNode());

        PairNode srcNode = new PairNode();
        srcNode.node = src;
        srcNode.distance = 0;
        pq.add(srcNode);

        while (!pq.isEmpty()) {
            PairNode current = pq.poll();
            int currNode = current.node;
            int currDist = current.distance;

            // Skip if we already found a shorter path
            if (currDist > dist[currNode])
                continue;

            for (int[] neighbor : adj[currNode]) {
                int nextNode   = neighbor[0];
                int edgeWeight = neighbor[1];
                int newDist    = dist[currNode] + edgeWeight;

                if (newDist < dist[nextNode]) {
                    dist[nextNode] = newDist;
                    PairNode nextPair = new PairNode();
                    nextPair.node     = nextNode;
                    nextPair.distance = newDist;
                    pq.add(nextPair);
                }
            }
        }
        return dist;
    }

}
