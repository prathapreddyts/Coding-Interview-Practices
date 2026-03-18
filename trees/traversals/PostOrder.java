package trees.traversals;

import java.util.ArrayList;
import java.util.List;

public class PostOrder {

    public List<Integer> postorder(TreeNode root) {
        List<Integer> postOrderList = new ArrayList<>();
        postOrderHelper(root, postOrderList);
        return postOrderList;
    }

    public void postOrderHelper(TreeNode root, List<Integer> postOrderList) {
        if (root == null) {
            return;
        }
        postOrderHelper(root.left, postOrderList);
        postOrderHelper(root.right, postOrderList);
        postOrderList.add(root.data);
    }
}
