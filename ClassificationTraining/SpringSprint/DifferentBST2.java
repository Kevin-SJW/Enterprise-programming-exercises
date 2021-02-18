package ClassificationTraining.SpringSprint;


import java.util.ArrayList;
import java.util.List;

/**
 * @Classname DifferentBST2
 * @Description TODO
 * @Date 2021/2/7 22:29
 * @Created by Administrator
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 */
public class DifferentBST2 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            List<TreeNode> res = new ArrayList<>();
            return res;
        }
        return generate(1, n);
    }

    public List<TreeNode> generate(int left, int right) {
        List<TreeNode> res = new ArrayList<>();
        if(left>right){
            res.add(null);
            return res;
        }
        for (int i = left; i <= right; i++) {
            List<TreeNode> lefts = generate(left,i-1);
            List<TreeNode> rights = generate(i+1,right);
            for (int j = 0; j < lefts.size(); j++) {
                for (int k = 0; k < rights.size(); k++) {
                    TreeNode root = new TreeNode(i);
                    root.left = lefts.get(j);
                    root.right = rights.get(k);
                    res.add(root);

                }
            }

        }
        return res;
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

