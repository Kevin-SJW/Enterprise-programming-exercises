package ClassificationTraining.huaweiMiddle;

import java.util.*;

/**
 * @Classname LargestValues
 * @Description TODO
 * @Date 2020/11/8 19:19
 * @Created by Administrator
 * 您需要在二叉树的每一行中找到最大的值。
 * <p>
 * 示例：
 * <p>
 * 输入:
 * <p>
 * 1
 * / \
 * 3   2
 * / \   \
 * 5   3   9
 * <p>
 * 输出: [1, 3, 9]
 */
public class LargestValues {

    private Map<Integer, List<Integer>> m = new TreeMap<>();

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderTraversal(root, 0);
        for (List<Integer> list : m.values()) {
            res.add(Collections.max(list));
        }
        return res;

    }

    private void preorderTraversal(TreeNode r, int d) {
        if (r == null) {
            return;
        }
        if (!m.containsKey(d)) {
            m.put(d, new ArrayList<>());
        }
        m.get(d).add(r.val);
        preorderTraversal(r.left, d + 1);
        preorderTraversal(r.right, d + 1);
    }

}
