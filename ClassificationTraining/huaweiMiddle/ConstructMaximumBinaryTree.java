package ClassificationTraining.huaweiMiddle;

/**
 * @Classname ConstructMaximumBinaryTree
 * @Description TODO
 * @Date 2020/12/5 16:39
 * @Created by Administrator
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 * <p>
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 */
public class ConstructMaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return constructTree(nums, 0, nums.length - 1);

    }

    private TreeNode constructTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int index = getMax(nums, start, end);
        TreeNode root = new TreeNode(nums[index]);
        root.left = constructTree(nums, start, index - 1);
        root.right = constructTree(nums, index + 1, end);
        return root;


    }

    private int getMax(int[] nums, int start, int end) {
        int index = start;
        for (int i = start; i <= end; i++) {
            if (nums[index] < nums[i]) {
                index = i;
            }
        }
        return index;
    }
}
