package ClassificationTraining.huaweiMiddle;

/**
 * @Classname DeleteNodeInBst
 * @Description TODO
 * @Date 2021/1/10 16:17
 * @Created by Administrator
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，
 * 并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * 一般来说，删除节点可分为两个步骤：
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
 * root = [5,3,6,2,4,null,7]
 * key = 3
 * 给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 * <p>
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 */
public class DeleteNodeInBst {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode r = root.right;
            while (r.left != null) {
                r = r.left;
            }
            root.right = deleteNode(root.right, r.val);//在右子树中删除该值
            root.val = r.val;//并将该值作为根结点的值

        }
        return root;
    }

    public TreeNode deleteNode2(TreeNode root, int key) {
        if (root == null) {
            return null;
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode r = root.right;
            while (r.left != null) {
                r = r.left;
            }
            root.right = deleteNode2(root.right, r.val);
            root.val = r.val;
        }
        return root;
    }
}
