package trees.traversals.mediumproblems;

import trees.traversals.TreeNode;

public class IsBalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);
        if (lh == -1 || rh == -1 || Math.abs(lh - rh) > 1) {
            return -1;
        }
        return 1 + Integer.max(lh, rh);
    }
}
