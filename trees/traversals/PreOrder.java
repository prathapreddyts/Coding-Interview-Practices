package trees.traversals;

import java.util.ArrayList;
import java.util.List;

public class PreOrder {

    public List<Integer> preOrder(TreeNode root) {
        List<Integer> preOrderList = new ArrayList<>();
        preOrderHelper(root, preOrderList);
        return preOrderList;
    }

    public void preOrderHelper(TreeNode root, List<Integer> preOrderList) {
        if (root == null) {
            return;
        }
        preOrderList.add(root.data);
        preOrderHelper(root.left, preOrderList);
        preOrderHelper(root.right, preOrderList);
    }

}
