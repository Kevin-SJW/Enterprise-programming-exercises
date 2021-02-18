package ClassificationTraining.huaweiMiddle;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname WidthOfBinaryTree
 * @Description TODO
 * @Date 2021/1/6 22:47
 * @Created by Administrator
 */
public class WidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        LinkedList<Integer> numbers = new LinkedList<>();
        numbers.add(1);
        int max = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int index = numbers.poll();
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                    numbers.add(2 * index + 1);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    numbers.add(2 * index + 2);
                }
            }
            if (numbers.size() > 2) {
                max = Math.max(max, numbers.getLast() - numbers.getFirst() + 1);
            }
        }
        return max;


    }
}
