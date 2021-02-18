package ClassificationTraining.SpringSprint;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname InorderTraversal
 * @Description TODO
 * @Date 2021/2/9 20:51
 * @Created by Administrator
 */
public class InorderTraversal {
    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        inOrder(root, 0);
        return res;
    }

    public void inOrder(TreeNode root, int d) {
        if (root == null) {
            return;
        }
        inOrder(root.left, d + 1);
        res.add(root.val);
        inOrder(root.right, d + 1);

    }


}
