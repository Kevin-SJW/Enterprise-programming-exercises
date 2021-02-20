package LeetCodeSimple;

/**
 * @Classname MinimunDepthOfBinaryTree
 * @Description TODO
 * @Date 2020/6/27 16:25
 * @Created by Administrator
 */
public class MinimunDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=minDepth(root.left);
        int right=minDepth(root.right);
        if(left==0){
            return right+1;
        }
        if(right==0){
            return left+1;
        }
        return Math.min(left,right)+1;

    }
}
