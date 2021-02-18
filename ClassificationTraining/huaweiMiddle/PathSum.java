package ClassificationTraining.huaweiMiddle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Classname PathSum
 * @Description TODO
 * @Date 2021/1/10 16:41
 * @Created by Administrator
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class PathSum {
    static List<List<Integer>> resList = new ArrayList<>();
    static List<Integer> tempList = new ArrayList<>();

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return resList;
    }

    public static void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        tempList.add(root.val);
        if (root.val == sum && root.left == null && root.right == null) {
            resList.add(new LinkedList<>(tempList));
        }
        dfs(root.left, sum - root.val);
        dfs(root.right, sum - root.val);
        tempList.remove(tempList.size() - 1);
    }
}
