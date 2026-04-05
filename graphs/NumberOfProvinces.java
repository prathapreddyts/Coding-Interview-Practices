package graphs;

import java.util.ArrayList;
import java.util.List;

public class NumberOfProvinces {
    public int numProvinces(int[][] adj) {
        int counter = 0;
        List<List<Integer>> adjList = getAdjList(adj);
        boolean[] visitedArray = new boolean[adj.length];
        for (int i = 0; i < adj.length; i++) {
            if (visitedArray[i] == false) {
                counter++;
                dfs(i, adjList, visitedArray);

            }
        }
        return counter;
    }

    public void dfs(int currentNode, List<List<Integer>> adjList, boolean[] visitedArray) {
        if (visitedArray[currentNode] == true) {
            return;
        }
        visitedArray[currentNode] = true;
        List<Integer> neighbourNodeList = adjList.get(currentNode);
        for (Integer neighbourNode : neighbourNodeList) {
            dfs(neighbourNode, adjList, visitedArray);
        }
    }

    public List<List<Integer>> getAdjList(int[][] adj) {
        List<List<Integer>> adjList = new ArrayList<>();

        int r = adj.length;
        int c = adj[0].length;

        for (int i = 0; i < r; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (adj[i][j] == 1 && i != j) {
                    adjList.get(i).add(j);
                }
            }
        }
        return adjList;
    }
}
