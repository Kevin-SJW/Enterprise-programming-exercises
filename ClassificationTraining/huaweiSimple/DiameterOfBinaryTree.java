package ClassificationTraining.huaweiSimple;

/**
 * @Classname DiameterOfBinaryTree
 * @Description TODO
 * @Date 2020/10/3 9:26
 * @Created by Administrator
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 * 这条路径可能穿过也可能不穿过根结点。
 */
public class DiameterOfBinaryTree {
    static int ans=0;
    public static int diameterOfBinaryTree(TreeNode root) {
        ans=1;
        depth(root);
        return ans-1;

    }

    public static int depth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=depth(root.left);
        int right=depth(root.right);
        ans=Math.max(ans,left+right+1);
        return Math.max(left,right)+1;
    }


}
