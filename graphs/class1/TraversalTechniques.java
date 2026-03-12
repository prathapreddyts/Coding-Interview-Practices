package graphs.class1;

import java.util.*;

public class TraversalTechniques {


    public List<Integer> dfsRecursiveOfGraphs(int nodes, List<List<Integer>> adj) {
        List<Integer> dfsResult = new ArrayList<>();
        boolean[] visitedArray=new boolean[nodes];
        dfsHelper(0,dfsResult,adj,visitedArray);
        return dfsResult;
    }

    public void dfsHelper(int currentNode, List<Integer> dfsList, List<List<Integer>> adj, boolean[] visitedArray) {
        if (visitedArray[currentNode]) {
            return;
        }
        dfsList.add(currentNode);
        visitedArray[currentNode]=true;
        List<Integer> neighbourNodes = adj.get(currentNode);
        for(Integer neighbourNode:neighbourNodes){
            if(!visitedArray[neighbourNode]){
                dfsHelper(neighbourNode,dfsList,adj,visitedArray);
            }
        }
    }

    public List<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
        List<Integer> dfsResult = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        stack.push(0);
        while (!stack.isEmpty()) {
            int currentNode = stack.pop();
            if (!visited[currentNode]) {
                visited[currentNode] = true;
                dfsResult.add(currentNode);
                List<Integer> neighbors = adj.get(currentNode);
                for (int i = neighbors.size() - 1; i >= 0; i--) {
                    int neighbor = neighbors.get(i);
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }
        return dfsResult;
    }

    public List<Integer> bfsOfGraph(int nodes, List<List<Integer>> adjList) {
        List<Integer> bfsList = new ArrayList<>();
        boolean[] visitedArray = new boolean[nodes];
        Queue<Integer> queue = new LinkedList();
        queue.add(0);
        visitedArray[0] = true;
        while (!queue.isEmpty()) {
            Integer currentNode = queue.poll();
            bfsList.add(currentNode);
            List<Integer> neighbourNodeList = adjList.get(currentNode);
            for (Integer neighbourNode : neighbourNodeList) {
                if (!visitedArray[neighbourNode]) {
                    visitedArray[neighbourNode] = true;
                    queue.add(neighbourNode);
                }
            }
        }
        return bfsList;
    }

    public List<Integer> bfsOnGraphsUsingStreams(int nodes, List<List<Integer>> adjNodeList) {
        List<Integer> bfsList = new ArrayList<>();
        boolean[] visitedArray = new boolean[nodes];
        Queue<Integer> queue = new LinkedList();
        queue.add(0);
        visitedArray[0] = true;

        while (!queue.isEmpty()) {
            Integer currentNode = queue.poll();
            bfsList.add(currentNode);
            adjNodeList.get(currentNode)
                    .stream()
                    .filter(neighbourNode -> !visitedArray[neighbourNode])
                    .forEach(neighbour -> {
                        visitedArray[neighbour] = true;
                        queue.add(neighbour);
                    });
        }


        return bfsList;
    }


}
