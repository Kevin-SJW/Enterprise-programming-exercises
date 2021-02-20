package LeetCodeSimple;

/**
 * @Classname BalancedBinaryTree
 * @Description TODO
 * @Date 2020/6/27 16:08
 * @Created by Administrator
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            // If root is unbalanced, then getDepth will return -1; else,
            // getDepth will return max depth
            return (getDepth(root) != -1);
        }

    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }


        int ld = getDepth(root.left);
        int rd = getDepth(root.right);
        if (ld == -1 || rd == -1 || Math.abs(ld - rd) > 1) {
            return -1;
        } else {
            return Math.max(ld, rd) + 1;
        }


    }
}
