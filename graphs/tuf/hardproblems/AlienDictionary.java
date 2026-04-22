package graphs.tuf.hardproblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {
    public String findOrder(String[] dict, int N, int K) {
        StringBuilder ans = new StringBuilder();
        List<Integer>[] adj = new ArrayList[K];

        for (int i = 0; i < K; i++) {
            adj[i] = new ArrayList<>();
        }
        //building adjacency list
        for (int i = 0; i < N - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int len = Math.min(s1.length(), s2.length());
            for (int ptr = 0; ptr < len; ptr++) {
                if (s1.charAt(ptr) != s2.charAt(ptr)) {
                    adj[s1.charAt(ptr) - 'a'].add(s2.charAt(ptr) - 'a');
                    break;
                }
            }
        }
        //building indegreeList
        int[] indegree = new int[K];
        for (int i = 0; i < K; i++) {
            for (int neighbor : adj[i]) {
                indegree[neighbor]++;
            }
        }
        // Step 4: Kahn's Algorithm (BFS)
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < K; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        StringBuilder result = new StringBuilder();

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.append((char) (node + 'a'));

            for (int neighbor : adj[node]) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return result.toString();
    }

}
