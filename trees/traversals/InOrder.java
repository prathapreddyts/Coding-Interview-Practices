package trees.traversals;

import java.util.ArrayList;
import java.util.List;

public class InOrder {
    public List<Integer> inorder(TreeNode root) {
        List<Integer> inOrderList = new ArrayList<>();
        inOrderHelper(root, inOrderList);
        return inOrderList;
    }

    public void inOrderHelper(TreeNode root, List<Integer> inOrderList) {
        if (root == null) {
            return;
        }
        inOrderHelper(root.left, inOrderList);
        inOrderList.add(root.data);
        inOrderHelper(root.right, inOrderList);
    }
}
