package ClassificationTraining.SpringSprint;

/**
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * 找出路径和等于给定数值的路径总数。
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 */
public class CountPath {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int result = countPath(root, sum);
        return result + pathSum(root.left, sum) + pathSum(root.right, sum);

    }

    public int countPath(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum -= root.val;
        int result = sum == 0 ? 1 : 0;
        return countPath(root.left, sum) + countPath(root.right, sum) + result;
    }
}
