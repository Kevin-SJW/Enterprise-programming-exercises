package ClassificationTraining.huaweiMiddle;

/**
 * @Classname InorderSuccessor
 * @Description TODO
 * @Date 2020/10/25 12:59
 * @Created by Administrator
 */
public class InorderSuccessor {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        TreeNode cur = root;
        TreeNode res = null;
        while (cur != null) {
            if (cur.val <= p.val) {
                cur = cur.right;
            } else {
                if (res == null || res.val > cur.val) {
                    res = cur;
                }
                cur = cur.left;
            }
        }
        return cur;
    }
}
