package ClassificationTraining.huaweiMiddle;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname IsEvenOddTree
 * @Description TODO
 * @Date 2020/11/1 16:37
 * @Created by Administrator
 * 如果一棵二叉树满足下述几个条件，则可以称为 奇偶树 ：
 * <p>
 * 二叉树根节点所在层下标为 0 ，根的子节点所在层下标为 1 ，根的孙节点所在层下标为 2 ，依此类推。
 * 偶数下标 层上的所有节点的值都是 奇 整数，从左到右按顺序 严格递增
 * 奇数下标 层上的所有节点的值都是 偶 整数，从左到右按顺序 严格递减
 * 给你二叉树的根节点，如果二叉树为 奇偶树 ，则返回 true ，否则返回 false 。
 */
public class IsEvenOddTree {

    public static boolean isEvenOddTree(TreeNode root) {
        int index = 0;
        if (root == null || root.val % 2 != 1) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int pre = index % 2 == 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            while (size > 0) {
                TreeNode t = queue.poll();
                int val = t.val;
                if (index % 2 == 0) {

                    if (pre >= val || val % 2 == 0) {
                        return false;
                    }
                    pre = val;
                } else {
                    if (pre <= val || val % 2 == 1) {
                        return false;
                    }
                    pre = val;
                }
                size--;
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }

            }
            index++;

        }
        return true;
    }
}
