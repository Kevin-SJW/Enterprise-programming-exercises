package ClassificationTraining.huaweiMiddle;

import java.util.*;

/**
 * @Classname DelNodes
 * @Description TODO
 * @Date 2020/10/2 9:25
 * @Created by Administrator
 * 给出二叉树的根节点 root，树上每个节点都有一个不同的值。
 * <p>
 * 如果节点值在 to_delete 中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。
 * <p>
 * 返回森林中的每棵树。你可以按任意顺序组织答案。
 */
public class DelNodes {
    private Set<Integer> set = new HashSet<>();
    private List<TreeNode> list = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] dels) {
        if (root == null) {
            return Collections.emptyList();
        }
        for (int del : dels) {
            set.add(del);
        }
        root = dfs(root);
        if (root != null) {
            list.add(root);
        }
        return list;
    }

    private TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = dfs(root.left);
        root.right = dfs(root.right);

        if (set.contains(root.val)) {
            if (root.left != null) {
                list.add(root.left);
            }
            if (root.right != null) {
                list.add(root.right);
            }
            return null;
        }
        return root;
    }


}
