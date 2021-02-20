package LeetCodeSimple;

/**
 * @Classname MaxisumDepthOfBinaryTree
 * @Description TODO
 * @Date 2020/6/27 15:15
 * @Created by Administrator
 */
public class MaxisumDepthOfBinaryTree {
    public static void main(String[] args) {

    }
    public static int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        return Math.max(left,right)+1;
    }
}
