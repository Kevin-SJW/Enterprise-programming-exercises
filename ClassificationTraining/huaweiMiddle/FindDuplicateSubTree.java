package ClassificationTraining.huaweiMiddle;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Classname FindDuplicateSubTree
 * @Description TODO
 * @Date 2020/9/2 23:42
 * @Created by Administrator
 */
public class FindDuplicateSubTree {
    LinkedList<TreeNode> res = new LinkedList<>();
    Map<String, Integer> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {


        if (root == null) return res;
        Duplicate(root);
        return res;
    }

    public String Duplicate(TreeNode root) {
        if (root == null) return "#";
        String temp = root.val + ',' + Duplicate(root.left) + ',' + Duplicate(root.right);//当前子树
        map.put(temp, map.getOrDefault(temp, 0) + 1);//是否重复
        if (map.get(temp) == 2)
            res.add(root);
        return temp;

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
