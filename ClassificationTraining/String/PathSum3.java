package ClassificationTraining.String;

/**
 * @Classname PathSum3
 * @Description TODO
 * @Date 2020/7/30 0:04
 * @Created by Administrator
 */

public class PathSum3 {

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int res = countPath(root, sum);
        int left = countPath(root.left, sum);
        int right = countPath(root.right, sum);
        return res + left + right;

    }

    public int countPath(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum -= root.val;
        int res = sum == 0 ? 1 : 0;
        return res + countPath(root.left, sum) + countPath(root.right, sum);
    }

    public int pathSum2(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int res = countPath2(root, sum);
        int left = countPath2(root.left, sum);
        int right = countPath2(root.right, sum);
        return res + left + right;

    }

    public int countPath2(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum -= root.val;
        int res = sum == 0 ? 1 : 0;
        return res + countPath2(root.left, sum) + countPath2(root.right, sum);
    }
}


//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

