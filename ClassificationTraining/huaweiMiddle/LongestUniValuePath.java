package ClassificationTraining.huaweiMiddle;

/**
 * @Classname LongestUniValuePath
 * @Description TODO
 * @Date 2020/9/6 10:35
 * @Created by Administrator
 */
public class LongestUniValuePath {
    private int max;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        postOrder(root, root.val);
        return max;
    }

    private int postOrder(TreeNode root, int val) {
        if (root == null) {
            return 0;
        }
        int left = postOrder(root.left, root.val);
        int right = postOrder(root.right, root.val);
        max = Math.max(max, left + right);
        if (root.val == val) {
            return Math.max(left, right) + 1;
        }
        return 0;
    }
}


