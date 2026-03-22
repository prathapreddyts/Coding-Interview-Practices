package trees.traversals.mediumproblems;

import trees.traversals.TreeNode;

public class IdenticalTrees {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.data != q.data) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSameTreeHeadRecursion(TreeNode p, TreeNode q) {

        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        boolean leftResult  = isSameTree(p.left, q.left);
        boolean rightResult = isSameTree(p.right, q.right);

        return leftResult && rightResult && (p.data == q.data);
    }
}

