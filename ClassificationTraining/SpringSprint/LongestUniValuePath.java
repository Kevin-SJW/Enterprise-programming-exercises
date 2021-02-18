package ClassificationTraining.SpringSprint;

/**
 * @Classname LongestUniValuePath
 * @Description TODO
 * @Date 2021/2/8 22:49
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。
 * 这条路径可以经过也可以不经过根节点。
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 * 输入:
 * 5
 * / \
 * 4   5
 * / \   \
 * 1   1   5
 * 输出:
 * 2
 */
public class LongestUniValuePath {
    public int max;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        postOrder(root, root.val);
        return max;
    }

    public int postOrder(TreeNode root, int val) {
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
