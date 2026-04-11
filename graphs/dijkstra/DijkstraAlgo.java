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
            if (currDist > dist[currNode]) continue;

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

    public static void main(String[] args) {
        /*
         *  Graph (0-indexed, undirected weighted):
         *
         *  0 --1-- 1 --2-- 2
         *  |               |
         *  4               1
         *  |               |
         *  3 ------1------ 4
         *
         *  Adjacency list (node -> [neighbor, weight]):
         *  0: [1,1], [3,4]
         *  1: [0,1], [2,2]
         *  2: [1,2], [4,1]
         *  3: [0,4], [4,1]
         *  4: [2,1], [3,1]
         */
        int nodes = 5;
        List<int[]>[] adj = new ArrayList[nodes];
        for (int i = 0; i < nodes; i++) adj[i] = new ArrayList<>();

        // Undirected edges
        adj[0].add(new int[]{1, 1}); adj[1].add(new int[]{0, 1});
        adj[1].add(new int[]{2, 2}); adj[2].add(new int[]{1, 2});
        adj[2].add(new int[]{4, 1}); adj[4].add(new int[]{2, 1});
        adj[3].add(new int[]{0, 4}); adj[0].add(new int[]{3, 4});
        adj[3].add(new int[]{4, 1}); adj[4].add(new int[]{3, 1});

        DijkstraAlgo algo = new DijkstraAlgo();
        int[] dist = algo.dijkstra(nodes, adj, 0);

        System.out.println("Shortest distances from node 0:");
        for (int i = 0; i < nodes; i++) {
            System.out.println("  Node " + i + " -> " + dist[i]);
        }
        // Expected: 0->0, 1->1, 2->3, 3->4, 4->4
    }
}
