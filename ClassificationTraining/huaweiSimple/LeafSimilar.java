package ClassificationTraining.huaweiSimple;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname LeafSimilar
 * @Description TODO
 * @Date 2020/10/1 15:14
 * @Created by Administrator
 */
public class LeafSimilar {

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        dfs(root1, list1);
        dfs(root2, list2);
        return list1.equals(list2);

    }

    public static void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            dfs(root.left, list);
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
        }
        if (root.right != null) {
            dfs(root.right, list);
        }
    }
}
