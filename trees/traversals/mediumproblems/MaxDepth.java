package trees.traversals.mediumproblems;

import trees.traversals.TreeNode;

public class MaxDepth {

    public int maxDepth(TreeNode root) {
       if(root==null){
           return 1;
       }
       int currentLeftDepth=maxDepth(root.left);
       int currentRightDepth=maxDepth(root.right);
       return Math.max(currentLeftDepth,currentRightDepth);
    }
}
