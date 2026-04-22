package graphs.interviewbit.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode rootNode) {
        ArrayList<ArrayList<Integer>> levelOrderList = new ArrayList<>();
        if (rootNode == null) {
            return levelOrderList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(rootNode);
        while (!queue.isEmpty()) {
            ArrayList<Integer> innerList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode polled = queue.poll();
                innerList.add(polled.val);
                if (polled.left != null) {
                    queue.add(polled.left);
                }
                if (polled.right != null) {
                    queue.add(polled.right);
                }

            }
            levelOrderList.add(innerList);
        }


        return levelOrderList;

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}
