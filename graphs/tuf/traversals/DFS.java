package graphs.tuf.traversals;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class DFS {
    public static void main(String[] args) {
        System.out.println("Hello world");
    }


    public static void dfsStackIterator(int start, List<List<Integer>> adj) {

        boolean[] visited = new boolean[adj.size()];
        Stack<Pair> stack = new Stack<>();
        visited[start] = true;
        stack.push(new Pair(start, adj.get(start).iterator()));
        while (!stack.isEmpty()) {
            Pair top = stack.peek();
            Iterator<Integer> neighbourListIterator = top.getIterator();
            if (neighbourListIterator.hasNext()) {
                int neighbor = neighbourListIterator.next();
                if (visited[neighbor]==false) {
                    visited[neighbor] = true;
                    stack.push(new Pair(neighbor, adj.get(neighbor).iterator()));
                }

            } else {
                stack.pop();
            }
        }
    }
}
