package LeetCodeSimple;

/**
 * @Classname SameTree
 * @Description TODO
 * @Date 2020/6/27 14:53
 * @Created by Administrator
 */

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
            if(p==null&&q==null){
                return true;
            }
            if(p==null||q==null){
                return false;
            }
            if(p.val!=q.val){
                return false;
            }
            return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
    }
}
